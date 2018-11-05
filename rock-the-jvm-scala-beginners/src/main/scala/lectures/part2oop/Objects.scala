package lectures.part2oop

/**
  *
  * @author vsushko
  */
object Objects extends App {

  // Scala does not have class level functionality
  // no concept of static

  val mary = new Person("Mary")
  val john = new Person("John")

  println(Person.N_EYES)
  val bobbie = Person(mary, john)

  class Person(name: String) {

  }

  println(mary == john)

  // Objects can have vals, vars, and functions
  // Objects do not receive parameters
  object Person {
    val N_EYES = 2

    def canFly: Boolean = false

    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }
}
