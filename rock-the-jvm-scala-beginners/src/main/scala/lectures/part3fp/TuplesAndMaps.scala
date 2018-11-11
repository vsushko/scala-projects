package lectures.part3fp

/**
  *
  * @author vsushko
  */
object TuplesAndMaps extends App {

  // tuples = finite ordered "lists"
  val aTuple = (2, "hello, Scala") // Tuple2[Int, String] = (Int, String)

  println(aTuple._1) // 2
  println(aTuple.copy(_2 = "goodbye Java"))
  println(aTuple.swap) // ("hello, Scala", 2)

  // Maps - keys -> values
  val aMap: Map[String, Int] = Map()
  val phoneBook = Map(("Jim", 555), "Daniel" -> 790).withDefaultValue(-1)
  // a -> b is sugar for (a, b)
  println(phoneBook)

  // map ops
  println(phoneBook.contains("Jim"))
  println(phoneBook("Jim"))
  println(phoneBook("Mary"))

  // add a pairing
  val newPairing = "Mary" -> 678
  val newPhoneBook = phoneBook + newPairing
  println(newPhoneBook)

  // functionals on maps
  // map, flatMap, filter
  println(phoneBook.map(pair => pair._1.toLowerCase() -> pair._2))

  // filterKeys
  println(phoneBook.filterKeys(x => x.startsWith("J")))

  // mapValues
  println(phoneBook.mapValues(number => number * 10))
  println(phoneBook.mapValues(number => number + "0245-" + number))

  // conversions to other collections
  println(phoneBook.toList)
  println(List(("Daniel", 555)).toMap)

  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))

  // exercises

}
