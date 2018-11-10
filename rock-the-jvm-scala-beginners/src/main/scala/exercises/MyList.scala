package exercises

/**
  *
  * @author vsushko
  */
abstract class MyList[+A] {

  def head: A

  def tail: MyList[A]

  def isEmpty: Boolean

  def add[B >: A](element: B): MyList[B]

  def printElements: String

  // polymorphic call
  override def toString: String = "[" + printElements + "]"

  def map[B](transformer: A => B): MyList[B]

  def flatMap[B](transformer: A => MyList[B]): MyList[B]

  def filter(predicate: A => Boolean): MyList[A]

  // concatenation
  def ++[B >: A](list: MyList[B]): MyList[B]
}

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException

  def tail: MyList[Nothing] = throw new NoSuchElementException

  def isEmpty: Boolean = true

  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)

  def printElements: String = ""

  // higher-order functions
  def map[B](transformer: Nothing => B): MyList[B] = Empty

  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty

  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h

  def tail: MyList[A] = t

  def isEmpty: Boolean = false

  def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements


  def filter(predicate: A => Boolean): MyList[A] =
    if (predicate(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)

  def map[B](transformer: A => B): MyList[B] =
    new Cons(transformer(h), t.map(transformer))

  // [1,2] ++ [3,4,5]
  // = new Cons(1, [2] ++ [3,4,5])
  // = new Cons(1, new Cons(2, Empty ++ [3,4,5]))
  // = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5)))))
  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)

  // [1,2].flatMap(n => [n, n+1]
  // = [1,2] ++ [2].flatMap(n => [n, n+1])
  // = [1,2] ++ [2,3] ++ Empty.flatMap(n => [n, n+1])
  // = [1,2] ++ [2,3] ++ Empty
  def flatMap[B](transformer: A => MyList[B]): MyList[B] =
    transformer(h) ++ t.flatMap(transformer)
}

object ListTest extends App {
  //  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
  //  println(list.tail.tail.head)
  //  println(list.add(4).head)
  //  println(list.isEmpty)
  //
  //  println(list.toString)
  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val cloneListOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val anotherListOfIntegers: MyList[Int] = new Cons(4, new Cons(5, Empty))
  val listOfStrings: MyList[String] = new Cons("hello", new Cons("Scala", Empty))

  println(listOfIntegers)
  println(listOfStrings)

  /*
   [1,2,3].map(n*2)
    = new Cons(2, [2,3].map(n * 2)
    = new Cons(2, new Cons(4, [3].map(n * 2)
    = new Cons(2, new Cons(4, new Cons(6, Empty.map(n*2))))
    = new Cons(2, new Cons(4, new Cons(6, Empty.map(n * 2))))
    = new Cons(2, new Cons(4, new Cons(6, Empty)))
   */
  println(listOfIntegers.map(_ * 2))

  /*
     [1, 2, 3].filter(n % 2 == 0) =
     [2,3].filter(n % 2 == 0) =
      = new Cons(2, [3].filter(n % 2 == 0))
      = new Cons(2, Empty.filter(n % 2 == 0))
      = new Cons(2, Empty)
   */
  println(listOfIntegers.filter(_ % 2 == 0).toString)

  println((listOfIntegers ++ anotherListOfIntegers).toString)

  println(listOfIntegers.flatMap(elem => new Cons(elem, new Cons(elem + 1, Empty))).toString)

  println(cloneListOfIntegers == listOfIntegers)
}

// Scala offers class-based inheritance
// * access modifiers: private, protected, default (none = public)
// * need to pass in constructor arguments to parent class
// Derived classes can override members or methods
// Reuse parent fields/ methods with super
// Prevent inheritance with final and sealed
// Inheriting from a class and multiple traits