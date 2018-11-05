package lectures.part2oop

/**
  *
  * @author vsushko
  */
object Generics extends App {

  class MyList[+A] {
    // use the type A
    def add[B >: A](element: B): MyList[B] = ???

    /*
    A = Cat
    B = Animal
     */
  }

  class MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal

  class Cat extends Animal

  class Dog extends Animal

  // does the list of Cat also extends the list of Animal?
  // 1. yes, List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]

  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]

  // aninalList.add(new Dog)??? HARD QUESTION => we return a list of Animals

  // 2. NO = INVARIANCE, we cant substitute one for another
  class InvariantList[A]

  // val invariantAnimalList: InvariantList[Animal] = new InvariantList[Cat]

  // 3. Hell, no! CONTRAVARIANCE
  class ContravariantList[-A]

  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]

  // bounded types - solves the variance problem
  // class Cage is subtype of Animal
  class Cage[A >: Animal](animal: A)

  val cage = new Cage(new Dog)

  class Car

  val newCage = new Cage(new Car)

  // expand MyList to be generic
}
