package chapter3

/**
  *
  * @author vsushko
  */
object Lists extends App {
  val oneTwoThree = List(1, 2, 3)

  println(oneTwoThree)

  // merging
  val oneTwo = List(1, 2)
  val threeFour = List(3, 4)

  val oneTwoThreeFour = oneTwo ::: threeFour
  println(oneTwoThreeFour)

  // cons
  val twoThree = List(2, 3)
  val anotherOneTwoThree = 1 :: twoThree
  println(anotherOneTwoThree)

  val list1 = 1 :: 2 :: 3 :: Nil
  println(list1)

  // not recommended
  val list2 = List(1, 2, 3, 4) :+ 5
  println(list2)

  val list3 = 6 :: list2
  println(list3.reverse)

  val list4 = List("a", "b") ::: List("c", "d")
  println(list4)
  println(list4(2))
  println(list4.count(s => s.length == 1))
  println(list4.drop(2))
  println(list4.dropRight(2))
  println(list4.exists(s => s == "a"))
  println(list4.filter(s => s == "b"))
  println(list4.forall(s => s.endsWith("a")))
  list4.foreach(s => print(s))
  println
  list4.foreach(print)
  println(list4.head)
  println(list4.init)
  println(list4.isEmpty)
  println(list4.last)
  println(list4.length)
  println(list4.map(s => s + "y"))
  println(list4.mkString(", "))
  println(list4.filterNot(s => s.length == 4))
  println(list4.reverse)
  println(list4.reverse.sortWith((s, t) => s.charAt(0).toLower < t.charAt(0).toLower))
  println(list4.tail)

  // tuples
  val pair = (99, "Luftballons")
  println(pair._1)
  println(pair._2)

  // immutable set
  var jetSet = Set("Boeing", "Airbus")
  jetSet += "Lear"
  println(jetSet.contains("Cessna"))

  // mutable set
  import scala.collection.mutable

  val movieSet = mutable.Set("Hitch", "Poltergeist")
  movieSet += "Shrek"
  println(movieSet)

  // immutable hash set
  import scala.collection.immutable.HashSet

  val hashSet = HashSet("Tomatoes", "Chilies")
  println(hashSet + "Coriander")
  println(hashSet)

  // map
  import scala.collection.mutable

  val treasureMap = mutable.Map[Int, String]()
  treasureMap += (1 -> "Go to island.")
  treasureMap += (2 -> "Find big X on ground.")
  treasureMap += (3 -> "Dig.")
  println(treasureMap)

  val romanNumeral = Map(1 -> "I", 2 -> "II", 3 -> "III", 4 -> "IV")
  println(romanNumeral)

  // function without side effects
  def formatArgs(args: Array[String]) = args.mkString("\n")

  println(formatArgs(args))

  // test
  val res = formatArgs(Array("zero", "one", "two"))
  assert(res == "zero\none\ntwo")

  import scala.io.Source

  def widthOfLength(s: String) = s.length.toString.length

  if (args.length > 0) {
    val lines = Source.fromFile(args(0)).getLines().toList
    val longestLine = lines.reduceLeft((a, b) => if (a.length > b.length) a else b)
    val maxWidth = widthOfLength(longestLine)

    for (line <- lines) {
      val numSpaces = maxWidth - widthOfLength(line)
      val padding = " " * numSpaces
      println(padding + line.length + " | " + line)
    }
  } else
    Console.err.println("Please enter filename")

  // classes




}

