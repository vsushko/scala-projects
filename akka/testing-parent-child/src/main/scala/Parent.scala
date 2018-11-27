import akka.actor.{Actor, ActorRef, ActorRefFactory}

/**
  *
  * @author vsushko
  */
class Parent(childMaker: ActorRefFactory => ActorRef) extends Actor {
  val child = childMaker(context)
  var ponged = false

  override def receive: Receive = {
    case "ping" => child ! "ping"
    case "pong" => ponged = true
  }
}
