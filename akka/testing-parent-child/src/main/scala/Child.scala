import akka.actor.{Actor, ActorRef}

/**
  *
  * @author vsushko
  */
class Child(parent: ActorRef) extends Actor {
  override def receive: Receive = {
    case "ping" => parent ! "pong"
  }
}
