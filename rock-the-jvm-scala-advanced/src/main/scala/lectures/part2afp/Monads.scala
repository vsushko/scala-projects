package lectures.part2afp

/**
  *
  * @author vsushko
  */
object Monads extends App {

  // our own Try monad

  trait Attempt[+A] {
    def flatMap[B](f: A => Attempt[B]): Attempt[B]
  }

  object Attempt {
    def apply[A](a: => A): Attempt[A] =
      try {
        Success(a)
      } catch {
        case e: Throwable => Fail(e)
      }
  }

  case class Success[+A](value: A) extends Attempt[A] {
    override def flatMap[B](f: A => Attempt[B]): Attempt[B] =
      try {
        f(value)
      } catch {
        case e: Throwable => Fail(e)
      }
  }

  case class Fail(E: Throwable) extends Attempt[Nothing] {
    override def flatMap[B](f: Nothing => Attempt[B]): Attempt[B] = this
  }

  // left-identity
  // uit.flatMap(f) = f(x)
  // Attempt(x).flatMap(f) = f(x) // Success case!
  // Success(x).flatMap(f) = f(x) // proved

  // right-identity
  // Success(x).flatMap(x => Attempt(x)) = Attempt(x) = Success(x)
  // Fail(e).FlatMap(...) = Fail(e)

  // associativity
  // attempt.flatMap(f).flatMap(g) == attempt.flatMap(x => f(x).flatMap(g))
  // Fail(e).flatMap(f).flatMap(g) = Fail(e)
  // Fail(e).flatMap(x => f(x).flatMap(g)) = Fail(e)
  // Success(v).flatMap(f).flatMap(g) =
  // f(v).flatMap(g) OR Fail(e)
  // Success(v).flatMap(x => f(x).flatMap(g)) = f(v).flatMap(g) OR Fail(e)

  val attempt = Attempt {
    throw new RuntimeException("My own monad, yes!")
  }

  println(attempt)

  // Lazy[T] monad = computation which will only  be executed when it's needed
  class Lazy[+A](value: => A) {
    // call by need
    private lazy val internalValue = value

    def use: A = internalValue

    def flatMap[B](f: (=> A) => Lazy[B]): Lazy[B] = f(internalValue)
  }

  object Lazy {
    def apply[A](value: => A): Lazy[A] = new Lazy(value)
  }

  val lazyInstance = Lazy {
    println("Today I don't feel like doing anything")
    42
  }
  println(lazyInstance.use)

  val flatMappedInstance = lazyInstance.flatMap(x => Lazy {
    10 * x
  })

  val flatMappedInstance2 = lazyInstance.flatMap(x => Lazy {
    10 * x
  })
  println
  flatMappedInstance.use
  flatMappedInstance2.use

  /*
    left-identity
    unit.flatMap(f) = f(v)
    Lazy(v).flatMap(f) = f(v)

    right-identity
    l.flatMap(unit) = l
    Lazy(v).flatMap(x => Lazy(x)) = Lazy(v)

    associativity: l.flatMap(f).flatMap(g) = l.flatMap(x => f(x).flatMap(g))

    Lazy(v).flatMap(f).flatMap(g) = f(v).flatMap(g)
    Lazy(v).flatMap(x => f(x).flatMap(g)) = f(v).flatMap(g)
   */

  // Monads = unit + flatMap
  // Monads = unit + map + flatten

  /*
  class Monad[T] { // List
    def flatMap[B](f: T => Monad[B]): Monad[B] = ...(implemented)

    def flatten(m: Monad[Monad[T]]): Monad[T] = m.flatMap((x: Monad[T]) => x)

    List(1, 2, 3).map(_ * 2) = List(1, 2, 3).flatMap(x => List(x * 2))
    List(List(1, 2), List(3, 4)).flatten = List(List(1, 2), List(3, 4)).flatMap(x => x) = List(1, 2, 3, 4)
  }
  */

}
