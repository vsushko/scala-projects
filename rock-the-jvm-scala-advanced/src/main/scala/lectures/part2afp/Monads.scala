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


}
