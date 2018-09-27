package week2

object Currying extends App {
  def sumInts = sum(x => x)
  def sumCubes = sum(x => x * x * x)
  def sumFactorials = sum(fact)
  def fact(x: Int): Int = if (x == 0) 1 else fact(x - 1)

  def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0 else f(a) + sumF(a + 1, b)
    sumF
  }

  println(sumCubes(1, 10) + sumFactorials(19, 20))

  def mapReduce(f: Int => Int,
                combine: (Int, Int) => Int, zero: Int)
               (a: Int, b: Int): Int =
    if (a > b) zero else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))

  def product(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b)
  println(product(x => x * x)(3, 4))

  def fact1(n: Int) = product(x => x)(1, n)
  println(fact1(5))


}
