package chaptere15

/**
  *
  * @author vsushko
  */
abstract class Expr

case class Var(name: String) extends Expr

case class Number(name: Double) extends Expr

case class UnOp(operator: String, arg: Expr) extends Expr

case class BinOp(operator: String, left: Expr, right: Expr) extends Expr


object Main {

  def simplifyTop(expr: Expr): Expr = expr match {
    case UnOp("-", UnOp("-", e)) => e // двойное отрицания
    case BinOp("+", e, Number(0)) => e // прибавление нуля
    case BinOp("+", e, Number(1)) => e // умнножение на еденицу
    case _ => expr
  }

  def describe(x: Any) = x match {
    case 5 => "five"
    case true => "truth"
    case "hello" => "hi!"
    case Nil => "the empty list"
    case _ => "something else"
  }

  def tupleDemo(expr: Any) = expr match {
    case (a, b, c) => println("matched " + a + b + c)
    case _ =>
  }

  def main(args: Array[String]) = {
    val v = Var("x")
    println(v)

    val op = BinOp("+", Number(1), v)
    println(op)

    println(v.name)
    println(op.left)
    println(op.right == Var("x"))
    println(op.right == Var("x"))

    println(simplifyTop(UnOp("-", Var("x"))))

    // describe
    println(describe(5))
    println(describe(true))
    println(describe("hello"))
    println(describe(Nil))
    println(describe(List(1, 2, 3)))

    // tupleDemo
    tupleDemo(("a ", 3, "-tuple"))

  }
}
