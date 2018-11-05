package lectures.part2oop

/**
  *
  * @author vsushko
  */
object AnonymousClasses extends App {

  // anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("ahahahahaha")
  }
  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"Hi, my name is Jim, how can I be of service?")


  }

  /*
    equivalent with

    class AnonymousClasses$$anon$1 extends Animal {
    override def eat: Unit = println("ahahahahhahahahaha")

    val funnyAnimal: Animal = new AnonymousClasses$$anon$1
  }*/

  println(funnyAnimal.getClass)

  abstract class Animal {
    def eat: Unit
  }

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name, how can I help?")
  }

}
