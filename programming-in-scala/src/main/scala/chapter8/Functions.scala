package chapter8

/**
  *
  * @author vsushko
  */
object Functions extends App {

  var increase = (x: Int) => {
    println("Increasing value")
    x + 1
  }
  println(increase(10))

  val someNumbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  someNumbers.foreach(x => print(x + " "))
  println
  println(someNumbers.filter(x => x > 5))
  println(someNumbers.filter(_ > 5))

  val f = (_: Int) + (_: Int)
  println(f(5, 10))

  def sum(a: Int, b: Int, c: Int) = a + b + c

  println(sum(1, 2, 3))

  val a = sum _
  println(a(1, 2, 3))

  val b = sum(1, _: Int, 3)
  println(b(2))

  // closures
  var more = 1
  val addMore = (x: Int) => x + more
  println(addMore(10))

  val someNumbers2 = List(-11, -10, -5, 0, 5, 10)
  var sum2 = 0
  someNumbers2.foreach(sum2 += _)

  def makeIncreaser(more: Int) = (x: Int) => x + more

  val inc1 = makeIncreaser(1)
  val inc9999 = makeIncreaser(9999)
  println(inc1(10))
  println(inc9999(10))

  // repeating parameters
  def echo(args: String*) =
    for (arg <- args) println(arg)

  echo("hello", "World")

  var arr = Array("What's", "up", "doc?")
  echo(arr: _*)

  // naming arguments
  def speed(distance: Float, time: Float): Float = distance / time

  println(speed(199, 10))
  println(speed(distance = 10, time = 100))
  println(speed(time = 100, distance = 10))

  def printTime(out: java.io.PrintStream = Console.out) =
    out.println("time = " + System.currentTimeMillis())

  def printTime2(out: java.io.PrintStream = Console.out, divisor: Int = 1) =
    out.println("time = " + System.currentTimeMillis() / divisor)

  printTime2(out = Console.err)
  printTime2(divisor = 1000)
}
