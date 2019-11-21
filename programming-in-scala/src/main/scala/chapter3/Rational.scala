package chapter3

/**
  *
  * @author vsushko
  */
class Rational(n: Int, d: Int) {
  require(d != 0)

  private val g = gcd(n.abs, d.abs)
  val numer: Int = n / g
  val denom: Int = d / g

  def this(n: Int) = this(n, 1)

  override def toString: String = numer + "/" + denom

  def +(that: Rational): Rational =
    new Rational(numer * that.denom + that.numer * denom, denom * that.denom)

  def +(i: Int): Rational =
    new Rational(numer + i * denom, denom)

  def -(that: Rational): Rational =
    new Rational(numer * that.denom - that.numer * denom, denom * that.denom)

  def -(i: Int): Rational =
    new Rational(numer - i * denom, denom)

  def *(that: Rational): Rational =
    new Rational(numer * that.numer, denom * that.denom)

  def *(i: Int): Rational =
    new Rational(numer * i, denom)

  def /(that: Rational): Rational =
    new Rational(numer * that.denom, denom * that.numer)

  def /(i: Int): Rational = new Rational(numer, denom * i)

  def lessThan(that: Rational) =
    this.numer * that.denom < that.numer * this.denom

  def max(that: Rational) =
    if (this.lessThan(that)) that else this

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}

object RationalTester extends App {
  val oneHalf = new Rational(1, 2)
  val twoThirds = new Rational(2, 3)
  println(oneHalf)
  println(twoThirds)

  //println((oneHalf / 7) + 1 - twoThirds)

  val x = new Rational(1, 3)
  val y = new Rational(5, 7)

  // println(new Rational(5, 0))

  println(oneHalf + twoThirds)

  println(new Rational(3))
  println(new Rational(66, 42))

  println(x + y)
  println(x * y)
  println((x + x) * y)
  println(y / y)
  println(y * y)
  println(x * 2)

  implicit def intToRational(x: Int) = new Rational(x)

  println(2 * x)

  // for
  val filesHere = (new java.io.File(".")).listFiles

  def fileLines(file: java.io.File) =
    scala.io.Source.fromFile(file).getLines().toList

  def grep(pattern: String) =
    for (file <- filesHere
         if file.getName.endsWith(".scala");
         line <- fileLines(file);
         trimmed = line.trim
         if trimmed.matches(pattern)
    ) println(file + ": " + trimmed)

  grep(".*gcd.*")

  def scalaFiles =
    for {
      file <- filesHere
      if file.getName.endsWith(".scala")
    } yield file

  val firstArg = if (args.length > 0) args(0) else ""

  var friend = firstArg match {
    case "salt" => println("pepper")
    case "chips" => println("salsa")
    case "eggs" => println("bacon")
    case _ => println("huh?")
  }

  println(friend)

  def makeRowSeq(row: Int) =
    for (col <- 1 to 10) yield {
      val prod = (row * col).toString
      val padding = " " * (4 - prod.length)
      padding + prod
    }

  def makeRow(row: Int) = makeRowSeq(row).mkString

  def multiTable() = {
    val tableSeq =
      for (row <- 1 to 10)
        yield makeRow(row)

    tableSeq.mkString("\n")
  }

  println(multiTable())

}