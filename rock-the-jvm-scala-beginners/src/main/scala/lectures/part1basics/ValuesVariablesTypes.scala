package lectures.part1basics

/**
  *
  * @author vsushko
  */
object ValuesVariablesTypes extends App {

  // vals are immutable
  // the types of val is optional
  // compiler can infer types
  val x: Int = 42
  println(x)

  val aString: String = "hello"
  val anotherString = "goodbye"

  val aByte: Byte = 121
  val aShort: Short = 4612
  val anInt: Int = x
  val aLong: Long = 412414142
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14
  val aChar: Char = 'a'
  val aBoolean: Boolean = false

  // variables are mutable
  var aVariable: Int = 4

  aVariable = 5 // side effects

}
