package chapter11

/**
  *
  * @author vsushko
  */
object Main extends App {
  val money = new Dollars(10000000)
  println(money)
}

class Dollars(val amount: Int) extends AnyVal {
  override def toString: String = "$" + amount
}
