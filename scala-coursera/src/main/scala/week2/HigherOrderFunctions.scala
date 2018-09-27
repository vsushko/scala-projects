package week2

object HigherOrderFunctions extends App {

  // take the sum of the integers between a and b
  def sumInts(a: Int, b: Int) = sum((x: Int) => x, a, b)
  def sumCubes(a: Int, b: Int) = sum((x: Int) => x * x * x, a, b)
  def sumFactorials(a: Int, b: Int) = sum(fact, a, b)

  def fact(x: Int): Int = if (x == 0) 1 else fact(x - 1)

  def sum(f: Int => Int, a: Int, b: Int): Int = {
    if (a > b) 0
    else f(a) + sum(f, a + 1, b)
  }

  println("sumInts=" + sumInts(1, 5))
  println("sumCubes=" + sumCubes(1, 5))
  println("sumFactorials=" + sumFactorials(1, 5))

  def sumWithTailRec(f: Int => Int)(a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, f(a) + acc)
    }
    loop(a, 0)
  }

  println(sumWithTailRec(x => x * x)(3, 5))
}
