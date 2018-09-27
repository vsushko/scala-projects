def fizzBuzz(n: Int): List[String] = {
  var newlist = List[String]()
  for (i <- 0 to n) {
    if (i%3==0) newlist = "Fizz" :: newlist
    else if (i%5==0) newlist = "Buzz" :: newlist
    else if (i%3==0 && i%5==0) newlist = "FizzBuzz" :: newlist
    else  newlist = i.toString :: newlist
  }

  newlist
}

println(fizzBuzz(30))

(4 :: List(1,2,3).reverse).reverse
