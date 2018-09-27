package week1

object FizzBuzz extends App {

  def fizzBuzz(n: Int): List[String] = {
    var list = List[String]()
    for (i <- 1 to n) {
      if (i % 3 == 0 && i % 5 == 0) list = "FizzBuzz" :: list
      else if (i % 3 == 0) list = "Fizz" :: list
      else if (i % 5 == 0) list = "Buzz" :: list
      else list = i.toString :: list
    }
    list.reverse
  }
  println(fizzBuzz(30))
}
