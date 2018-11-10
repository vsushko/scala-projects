package lectures.part3fp

/**
  *
  * @author vsushko
  */
object AnonymousFunctions extends App {

  // anonymous function (lambda)
  // val doubler: Int => Int = x => x * 2
  val doubler = (x: Int) => x * 2
  println(doubler(2))

  // multiple params in a lambda
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b
  println(adder(2, 3))

  // no params
  val justDoSomething = () => 3
  println(justDoSomething) // function itself
  println(justDoSomething()) // call

  // curly braces with lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // MOAR syntactic sugar
  val niceIncrementer: Int => Int = _ + 1 // equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ // equivalent to (a, b) => a + b

  val superAdd = (x: Int) => (y: Int) => x + y
  println(superAdd(3)(4))
}
