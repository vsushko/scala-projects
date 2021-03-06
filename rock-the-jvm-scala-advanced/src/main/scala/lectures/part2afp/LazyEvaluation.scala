package lectures.part2afp

/**
  *
  * @author vsushko
  */
object LazyEvaluation extends App {

  // lazy delays the evaluation of values
  lazy val x: Int = {
    println("Hello")
    42
  }
  println(x)
  println(x)

  // examples of implications:
  // side effects
  def sideEffectCondition: Boolean = {
    println("Boo")
    true
  }

  def simpleCondition: Boolean = false

  lazy val lazyCondition = sideEffectCondition
  println(if (simpleCondition && lazyCondition) "yes" else "no")

  // in conjunction with call by name
  def byNameMethod(n: => Int): Int = {
    // CALL BY NEED
    lazy val t = n // only evaluated once
    t + t + t + 1
  }

  def retrieveMagicValue: Int = {
    // side effect or a long computation
    println("waiting")
    Thread.sleep(1000)
    42
  }

  println(byNameMethod(retrieveMagicValue))

  // use lazy vals

  // filtering with lazy vals
  def lessThan30(i: Int): Boolean = {
    println(s"$i is less than 30?")
    i < 30
  }

  def greaterThan20(i: Int): Boolean = {
    println(s"$i is greater than 20?")
    i > 20
  }

  val numbers = List(1, 35, 40, 5, 23)
  val lt30 = numbers.filter(lessThan30) // List(1, 25, 5, 23)
  val gt20 = numbers.filter(greaterThan20) // List(1, 25, 5, 23)
  println(gt20)

  val lt30lazy = numbers.withFilter(lessThan30)
  val gt20lazy = numbers.withFilter(greaterThan20)

  println
  gt20lazy.foreach(println)

  // for-comprehensions use withFilter with guards
  for {
    a <- List(1, 2, 3) if a % 2 == 0 // use lazy vals
  } yield a + 1

  List(1, 2, 3).withFilter(_ % 2 == 0).map(_ + 1) // List[Int]

  /*
    Exercise: implement a lazily evaluated, singly linked STREAM of elements.

    naturals = MyStream.from(1)(x => x + 1) = stream of natural numbers (potentially infinite!)

    naturals.take(100).foreach(println) // lazily evaluated stream of the first 100 naturals (finite stream)
    naturals.foreach(println) // will crash - infinite
    naturals.map(_ * 2) // stream of all even number (potentially infinite)
   */


}
