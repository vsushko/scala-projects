import Aphrodite.{RestartException, ResumeException, StopException}
import akka.actor.SupervisorStrategy._
import akka.actor.{Actor, ActorRef, ActorSystem, OneForOneStrategy, Props}

import scala.concurrent.duration._
import scala.language.postfixOps

/**
  *
  * @author vsushko
  */
class Aphrodite extends Actor {

  def receive = {
    case "Resume" =>
      throw ResumeException
    case "Stop" =>
      throw StopException
    case "Restart" =>
      throw RestartException
    case _ =>
      throw new Exception
  }

  override def preStart(): Unit = {
    println("Aphrodite preStart hook...")
  }

  override def postStop(): Unit = {
    println("Aphrodite postStop...")
  }

  override def preRestart(reason: Throwable, message: Option[Any]): Unit = {
    println("Aphrodite postRestart hook...")
    super.preRestart(reason, message)
  }

  override def postRestart(reason: Throwable): Unit = {
    println("Aphrodite postRestart hook...")
    super.postRestart(reason)
  }
}

object Aphrodite {

  case object ResumeException extends Exception

  case object StopException extends Exception

  case object RestartException extends Exception

}

class Hera extends Actor {

  import Aphrodite._

  var childRef: ActorRef = _

  override val supervisorStrategy =
    OneForOneStrategy(maxNrOfRetries = 10, withinTimeRange = 1 second) {
      case ResumeException => Resume
      case StopException => Restart
      case RestartException => Stop
      case _: Exception => Escalate
    }

  override def preStart(): Unit = {
    // create Aphrodite Actor
    childRef = context.actorOf(Props[Aphrodite], "Aphrodite")
    Thread.sleep(100)
  }

  override def receive: Receive = {
    case msg =>
      println(s"Hera received ${msg}")
      childRef ! msg
      Thread.sleep(100)
  }
}

object Supervision extends App {

  // create the 'supervision' actor system
  val system = ActorSystem("supervision")

  // create Hera Actor
  val hera = system.actorOf(Props[Hera], "hera")

//  hera ! "Resume"
//  Thread.sleep(1000)
//  println()

//    hera ! "Restart"
//    Thread.sleep(1000)
//    println()

    hera ! "Stop"
    Thread.sleep(1000)
    println()

  system.terminate()

}
