package chapter12

import scala.collection.mutable.ArrayBuffer

/**
  *
  * @author vsushko
  */
object Main extends App {

  val frog = new Frog
  println(frog.philosophize())

  val phrog: Philosophical = new Frog
  println(phrog.philosophize())

  val rect = new Rectangle(new Point(1, 1), new Point(10, 10))
  println(rect.left)
  println(rect.right)
  println(rect.width)

  val queue = new BasicIntQueue
  queue.put(10)
  queue.put(20)
  println(queue.get())
  println(queue.get())

  val queue2 = new MyQueue
  queue2.put(10)
  println(queue2.get())

  val queue3 = new BasicIntQueue with Doubling
  queue3.put(10)
  println(queue3.get())

  val queue4 = (new BasicIntQueue with Incrementing with Filtering)
  queue4.put(-1)
  queue4.put(0)
  queue4.put(1)

  println(queue4.get())
  println(queue4.get())


  val queue5 = (new BasicIntQueue with Filtering with Incrementing)
  queue5.put(-1)
  queue5.put(0)
  queue5.put(1)

  println(queue5.get())
  println(queue5.get())
  println(queue5.get())

}

trait Philosophical {
  def philosophize() = {
    println("I consume memory, therefore I am!")
  }
}

trait HasLegs

class Animal

class Frog extends Animal with Philosophical with HasLegs {
  override def philosophize(): Unit = {
    println("It ain't easy being " + toString + "!")
  }

  override def toString: String = "green"
}

trait CharSequence {
  def charAt(index: Int): Char

  def length: Int

  def subSequence(start: Int, end: Int): CharSequence

  def toString(): String
}

class Point(val x: Int, val y: Int)

class Rectangle(val topLeft: Point, val bottomRight: Point) extends Rectangular {
}

abstract class Component extends Rectangular {
}

trait Rectangular {
  def topLeft: Point

  def bottomRight: Point

  def left = topLeft.x

  def right = bottomRight.x

  def width = right - left
}

class Rational(n: Int, d: Int) extends Ordered[Rational] {
  val numer: Int = n
  val denom: Int = d

  override def compare(that: Rational): Int = (this.numer * that.denom) - (that.numer * this.denom)
}

abstract class IntQueue {
  def get(): Int

  def put(x: Int)
}

class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]

  override def get(): Int = buf.remove(0)

  override def put(x: Int): Unit = buf += x
}

trait Doubling extends IntQueue {
  abstract override def put(x: Int): Unit = {
    super.put(2 * x)
  }
}

class MyQueue extends BasicIntQueue with Doubling

trait Incrementing extends IntQueue {
  abstract override def put(x: Int): Unit = {
    super.put(x + 1)
  }
}

trait Filtering extends IntQueue {
  abstract override def put(x: Int): Unit = {
    if (x >= 0) super.put(x)
  }
}