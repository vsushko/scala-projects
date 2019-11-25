package chapter9

import java.io.{File, PrintWriter}

/**
  *
  * @author vsushko
  */
object Main extends App {

  def containsNeg1(nums: List[Int]): Boolean = {
    var exists = false
    for (num <- nums)
      if (num < 0)
        exists = true
    exists
  }

  def containsNeg2(nums: List[Int]) = nums.exists(_ < 0)

  println(containsNeg1(List(1, 2, 3, 4)))
  println(containsNeg1(List(1, 2, -3, 4)))

  println(containsNeg2(List(1, 2, 3, 4)))
  println(containsNeg2(List(1, 2, -3, 4)))

  def containsOdd1(nums: List[Int]): Boolean = {
    var exists = false
    for (num <- nums)
      if (num % 2 == 1)
        exists = true
    exists
  }

  def containsOdd2(nums: List[Int]) = nums.exists(_ % 2 == 1)

  println(containsOdd1(List(1, 2, 3, 4)))
  println(containsOdd1(List(2, 4)))

  println(containsOdd2(List(1, 2, 3, 4)))
  println(containsOdd2(List(2, 4)))

  // curried method
  def curriedSum(x: Int)(y: Int): Int = x + y

  println(curriedSum(1)(2))

  def first(x: Int) = (y: Int) => x + y

  val second = first(1)
  println(second(2))

  val onePlus = curriedSum(1) _
  println(onePlus(2))

  val twoPlus = curriedSum(2) _
  println(twoPlus(2))

  def withPrintWriter(file: File)(op: PrintWriter => Unit) = {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }

  val file = new File("date.txt")

  withPrintWriter(file) { writer =>
    writer.println(new java.util.Date)

  }
}
