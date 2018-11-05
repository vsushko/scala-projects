package lectures.part2oop

/**
  *
  * @author vsushko
  */
object CaseClasses extends App {

  /*
    equals, hashCode, toString
   */

  // 1. class parameters are fields
  val jim = new Person("Jim", 34)
  // 3. equals and hashCode implemented OOTB
  val jim2 = new Person("Jim", 34)
  println(jim.name)

  // 2. sensible toString
  // println(instance) = println(instance.toString) // syntactic sugar
  println(jim.toString)
  println(jim)
  // 4. Case classes have handy copy method
  val jim3 = jim.copy(age = 45)
  println(jim == jim2)
  // 5. Case classes have companion objects
  val thePerson = Person
  println(jim3)
  val mary = Person("Mary", 23)

  case class Person(name: String, age: Int)
  println(mary)

  // 6. Case classes are serializable
  // Akka

  // 7. Case classes have extractor patterns = Case classes can be used in PATTERN MATCHING

  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }

  /*
   Expand MyList - use case classes and case objects
   */

  // case classes = lightweight data structures with little boilerplate
  // companions already implemented
  // sensible equals, hashCode, toString
  // Auto-promoted params to fields
  // Cloning


}
