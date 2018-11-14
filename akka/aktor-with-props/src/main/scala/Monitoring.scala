import akka.actor.{Actor, ActorRef, ActorSystem, Props, Terminated}

/**
  *
  * @author vsushko
  */
class Ares(athena: ActorRef) extends Actor {

  override def preStart(): Unit = {
    context.watch(athena)
  }

  override def postStop(): Unit = {
    println("Ares postStop...")
  }

  override def receive: Receive = {
    case Terminated(_) =>
      context.stop(self)
  }
}

class Athena extends Actor {

  override def receive: Receive = {
    case msg => println(s"Athena received ${msg}")
      context.stop(self)
  }
}

object Monitoring extends App {
  // create the 'monitoring' actor system
  val system = ActorSystem("monitoring")

  val athena = system.actorOf(Props[Athena], "athena")

  val ares = system.actorOf(Props(classOf[Ares], athena), "ares")

  athena ! "Hi"

  Thread.sleep(500)

  system.terminate()
}
