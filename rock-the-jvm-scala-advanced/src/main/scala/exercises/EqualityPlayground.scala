package exercises

import lectures.part4implicits.TypeClasses.User

/**
  *
  * @author vsushko
  */
object EqualityPlayground extends App {

  /*
    Equality
   */
  trait Equal[T] {
    def apply(a: T, b: T): Boolean
  }

  object NameEquality extends Equal[User] {
    override def apply(a: User, b: User): Boolean = a.name == b.name
  }

  implicit object FullEquality extends Equal[User] {
    override def apply(a: User, b: User): Boolean = a.name == b.name && a.email == b.email
  }

  /*
    Exercise: implement the TC patter for the Equality tc
  */

  object Equal {
    def apply[T](a: T, b: T)(implicit equalizer: Equal[T]): Boolean =
      equalizer.apply(a, b)
  }

  // AD-HOC polymorphism
  val john = User("John", 32, "john@rockthejvm.com")
  val anotherJohn = User("John", 45, "anotherJohn@rtjvm.com")
  println(Equal(john, anotherJohn))

  /* exercise - improve the Equal TC with an implicit conversion class
   ===(another value: T)
   !==(anotherValue: T)
  */

  implicit class TypeSafeEqual[T](value: T) {
    def ===(other: T)(implicit equalizer: Equal[T]): Boolean = equalizer.apply(value, other)

    def !==(other: T)(implicit equalizer: Equal[T]): Boolean = !equalizer.apply(value, other)
  }

  println(john === anotherJohn)
  /*
      john.===(anotherJohn)
      new TypeSafeEqual[User](john).===(anotherJohn)
      new TypeSafeEqual[User](john).===(anotherJohn)(NameEquality
   */

  /*
      Type Safe
   */

  println(john == 43)
  // println(john === 43) // TypeSafe
}
