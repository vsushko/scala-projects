package fromjavainaction

import scala.io.Source

object MyClass extends App {

  override def main(args: Array[String]) {
    // 2 to 6 is infix form and an int object in Scala
    // support a method named to: 2.to(6)
    2 to 6 foreach { n => println(s"Hello ${n} bottles of beer")}

    // val authorsToAge : Map[String, Int] but Scala infers the type of the variable
    val authorsToAge = Map("Raoul" -> 23, "Mario" -> 40, "Alan" -> 53)
    val authors = List("Raoul", "Mario", "Alan")
    val numbers = Set(1, 1, 2, 3, 5, 8)

    val newNumbers = numbers + 9
    println(newNumbers)
    println(numbers)

    val fileLines = Source.fromFile("data.txt").getLines().toList
    var linesLongUpper = fileLines.filter(l => l.length() > 10).map(l => l.toUpperCase())
    linesLongUpper.foreach(println)
    // (_) is a placeholder that's positionally matched to any arguments
    // equivalent to l => l.length()
    val linesLongUpper2 = fileLines filter(_.length > 10) map(_.toUpperCase())
    linesLongUpper.foreach(println)

    // as for a pipeline to be executed in parallel like in java by calling
    // parallel on a Stream, par is a trick
    val linesLongUpper3 = fileLines.par filter(_.length() > 10) map (_.toUpperCase())
    linesLongUpper.foreach(println)

    // tuples
    val roul = ("Raoul", "+ 44 887007007")
    val alan = ("Alan", "+44 883133700")

    // scala supporst arbitrary-sized tuples, 23 elements is maximum
    val myTuple = (2018, "Vasiliy", "Sushko")
    println(myTuple)
    println(myTuple._1)
    val tupleOfNumbers = (42, 1337, 0, 3, 14)
    println(tupleOfNumbers)
    println(tupleOfNumbers._4)

    // closures
    var count = 0
    // a closure capturing and incrementing count
    val inc = () => count += 1
    inc()
    println(count)
    inc()
    println(count)

    // defining a curried function
    def multiplyCurry(x : Int)(y : Int) = x * y

    // invoking a curried function
    val r = multiplyCurry(2)(10)
    println(r)

    val multiplyByTwo : Int => Int = multiplyCurry(2)
    val r2 = multiplyByTwo(11)
    println(r2)


  }
}

trait Sized {
  // a field called size
  var size : Int = 0
  // a method called isEmpty with a default implementation
  def isEmpty() = size == 0
}

// a class inheriting from the trait Sized
class Empty extends Sized {
  println(new Empty().isEmpty())
}

class Box {
  // composing the trait at object instantiation time
  val b1 = new Box() with Sized
  // prints tru
  println(b1.isEmpty())
  val b2 = new Box()
  // Compile error: the Box class declaration
  // doesn't inherit from Sized
  // b2.isEmpty()
}