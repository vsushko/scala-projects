package lectures.part2oop

/**
  *
  * @author vsushko
  */
object Generics extends App {

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]
  val emptyListOfIntegers = MyList.empty[Int]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]
  val cage = new Cage(new Dog)
  val newCage = new Cage(new Car)

  class MyList[+A] {
    // use the type A
    def add[B >: A](element: B): MyList[B] = ???

    /*
    A = Cat
    B = Animal
     */
  }

  class MyMap[Key, Value]

  // variance problem
  class Animal

  class Cat extends Animal

  // aninalList.add(new Dog)??? HARD QUESTION => we return a list of Animals

  class Dog extends Animal

  // val invariantAnimalList: InvariantList[Animal] = new InvariantList[Cat]

  // does the list of Cat also extends the list of Animal?
  // 1. yes, List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]

  // 2. NO = INVARIANCE, we cant substitute one for another
  class InvariantList[A]

  // 3. Hell, no! CONTRAVARIANCE
  class ContravariantList[-A]

  // bounded types - solves the variance problem
  // class Cage is subtype of Animal
  class Cage[A >: Animal](animal: A)

  class Car

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  // expand MyList to be generic
}
