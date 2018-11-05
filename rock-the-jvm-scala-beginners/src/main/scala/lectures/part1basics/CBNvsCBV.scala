package lectures.part1basics

/**
  *
  * @author vsushko
  */
object CBNvsCBV extends App {
  def calledByValue(x: Long): Unit = {
    println("by value " + x)
    println("by value " + x)
  }

  // => tells to compiler that the parameter would be called by name
  def calledByName(x: => Long): Unit = {
    println("by name " + x)
    println("by name " + x)
  }

  // prints two identical values
  calledByValue(System.nanoTime())
  // prints two different values
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()

  def printFirst(x: Int, y: => Int) = println(x)

  // causes stackoverflowerror
  // println(printFirst(infinite(), 34))
  printFirst(34, infinite())

  // call by value:
  // value is computed before call
  // same value used everywhere
  // call by name:
  // expression is passed literally
  // expression is evaluated at every use within
}
