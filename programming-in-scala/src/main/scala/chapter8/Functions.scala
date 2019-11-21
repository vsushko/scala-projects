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
}
