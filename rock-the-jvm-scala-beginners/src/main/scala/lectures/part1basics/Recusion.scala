package lectures.part1basics

import scala.annotation.tailrec

/**
  *
  * @author vsushko
  */
object Recusion extends App {

  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of (" + (n - 1) + ")")
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)
      result
    }

  // println(factorial(15000))

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      // tail recursion = use recursive call as the last expression
      else factHelper(x - 1, x * accumulator)

    factHelper(n, 1)
  }

  /*
  anotherFactorial(10) = factHelper(10, 1)
  = factHelper(9, 10 * 1)
  = factHelper(8, 9 * 10 * 1)
  = factHelper(7, 8 * 9 * 10 * 1)
  = factHelper(9, 10 * 1)
    ...
  = factHelper(2, 3 * 4 * ... * 10 * 1)
  = factHelper(1, 2 * 3 * 4 * ... * 10 * 1)
  = return 1 * 2 * 3 * 4 * ... * 10
   */
  println(anotherFactorial(5000))

  // when you need loops, use _tail_ recursion

  @tailrec
  def concatenateTailRec(aString: String, n: Int, accumulator: String): String =
    if (n <= 0) accumulator
    else concatenateTailRec(aString, n - 1, aString + accumulator)


  println(concatenateTailRec("Hello", 3, ""))

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t - 1, n % t != 0 && isStillPrime)

    isPrimeTailrec(n / 2, true)
  }

  println(isPrime(2003))
  println(isPrime(629))

  def fibonacci(n: Int): Int = {
    def fiboTailRec(i: Int, last: Int, nextToLast: Int): Int =
      if (i >= n) last
      else fiboTailRec(i + 1, last + nextToLast, last)

    if (n <= 2) 1
    else fiboTailRec(2, 1, 1)
  }

  println(fibonacci(8))
}
