package lectures.part1basics

/**
  *
  * @author vsushko
  */
object Expressions extends App {

  val x = 1 + 2 // expression
  println(x)
  println(2 + 3 * 4)
  // + - * / ^ & | << >> >>>

  println(1 == x)

  // ==  != > >= < <=

  println(!(1 == x))

  var aVariable = 2
  aVariable += 3 // also words with -= *= /= .... size effects
  println(aVariable)

  // instructions(DO) vs expression

  // IF expression
  val aCondition = true
  val aConditionValue = if (aCondition) 5 else 3 // IF expression
  println(aConditionValue)
  println(if (aCondition) 5 else 3)

  var i = 0
  while (i < 10) {
    print(i + " ")
    i += 1
  } // never write this again, it is imperative code
  println()

  i = 0
  val aWhile = while (i < 10) {
    print(i + " ")
    i += 1
  }
  println()
  // everything in Scala is an Expression

  val aWeirdValue = (aVariable = 3) // Unit === void
  println(aWeirdValue)

  // side effects: println, whiles, reassigning

  // code blocks

  // value of the block is the value of its last expression
  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if (z > 2) "hello" else "goodbye"
  }
  // instructions are executed (think java), expression are evaluated (Scala)
  // in Scala we'll think in terms of expressions

  val someValue = {
    2 < 3
  }
  println(someValue)

  val someOtherValue = {
    if (someValue) 239 else 935
    42
  }
  println(someOtherValue)
}
