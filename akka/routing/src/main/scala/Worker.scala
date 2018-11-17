import Worker.Work
import akka.actor.Actor

/**
  *
  * @author vsushko
  */
class Worker extends Actor {
  override def receive: Receive = {
    case msg: Work =>
      println(s"I received Work Message and My ActorRef: ${self}")
  }
}

object Worker {

  case class Work()

}