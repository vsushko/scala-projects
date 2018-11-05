package lectures.part2oop

/**
  *
  * @author vsushko
  */
object Inheritance extends App {

  val cat = new Cat
  val dog = new Dog

  class Animal {
    protected def eat = println(s"Nom, nom, nom")
  }
  cat.crunch

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  class Dog extends Animal {
    override def eat = println("Crunch Woof!")
  }
  dog.eat
}
