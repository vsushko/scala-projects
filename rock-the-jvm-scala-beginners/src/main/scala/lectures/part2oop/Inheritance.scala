package lectures.part2oop

/**
  *
  * @author vsushko
  */
object Inheritance extends App {

  class Animal {
    protected def eat = println(s"Nom, nom, nom")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  class Dog extends Animal {
    override def eat = println("Crunch Woof!")
  }

  val dog = new Dog
  dog.eat
}
