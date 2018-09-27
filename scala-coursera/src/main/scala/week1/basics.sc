// values
val two = 1 + 1

// variables
var name = "Vasiliy"
name = "Vasilii"

// functions
def addOne(m: Int): Int = m + 1

val three = addOne(2)

def threeFunc() = 1 + 2

threeFunc()

threeFunc

// anonymous functions

(x: Int) => x + 1

val addOneFunc = (x: Int) => x + 1

addOneFunc(1)

def timesTwo(i: Int): Int = {
  println("Hello world")
  i * 2
}

timesTwo(2)

val functionWithoutName = { i: Int =>
  println("Hello world!")
  i * 2
}

functionWithoutName(2)

// partial application

List(1,2,3) :+ 4