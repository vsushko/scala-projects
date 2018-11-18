import akka.actor.Actor

/**
  *
  * @author vsushko
  */
class Worker extends Actor {

  import Worker._

  override def receive: Receive = {
    case msg: Work =>
      println(s"I received Work message and my ActorRef: ${self}")
  }
}

object Worker {

  case class Work(message: String)

}