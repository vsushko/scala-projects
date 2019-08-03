package lectures.part4implicits

/**
  *
  * @author vsushko
  */
object OrganizingImplicits extends App {

  implicit val reverseOrdering: Ordering[Int] = Ordering.fromLessThan(_ > _)

  //implicit val reverseOrdering: Ordering[Int] = Ordering.fromLessThan(_ < _)
  println(List(1, 4, 2, 1, 5).sorted)

  // scala.Predef

  /*
      Implicits (used as implicit parameters:
       - val/var
       - object
       - accessor methods = defs with no parameters
   */

  // exercise
  case class Person(name: String, age: Int)

  val persons = List(
    Person("Steve", 30),
    Person("Amy", 22),
    Person("John", 66)
  )

  /*
      Implicit scope
       - normal scope = LOCAL SCOPE
       - imported scope
       - companions of all types involved in the method signature
          - List
          - Ordering
          - all the types involved = A or any supertype

  Best practices

  When defining an implicit val:

  #1:
    * if there is a single possible value for it
    * and you can edit the code for the type
    then define the implicit in the companion
  #2:
    * if there is are many possible values for it
    * but a single good one
    * and you can edit the code for the type
    then define the good implicit in the companion
   */

  object AlphabeticNameOrdering {
    implicit var alphabeticOrdering: Ordering[Person] = Ordering.fromLessThan((a, b) => a.name.compareTo(b.name) < 0)
  }

  object AgeOrdering {
    implicit var ageOrdering: Ordering[Person] = Ordering.fromLessThan((a, b) => a.age < b.age)
  }

  import AlphabeticNameOrdering._

  println(persons.sorted)

  /*
    Exercise

      - totalPrice = most used (50%)
      - by unit count = 25%
      - by unit price = 25%
   */

  case class Purchase(nUnits: Int, unitPrice: Double)

  object Purchase {
    implicit val totalPriceOrdering: Ordering[Purchase] = Ordering.fromLessThan((a, b) => a.nUnits * a.unitPrice < b.nUnits * b.unitPrice)
  }

  object UnitCountOrdering {
    implicit val unitCountOrdering: Ordering[Purchase] = Ordering.fromLessThan(_.nUnits < _.nUnits)
  }

  object UnitPriceOrdering {
    implicit val unitPriceOrdering: Ordering[Purchase] = Ordering.fromLessThan(_.unitPrice < _.unitPrice)
  }


}
