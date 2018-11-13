package example

import akka.actor.{Actor, ActorSystem, Props}

/**
  *
  * @author vsushko
  */
case class WhoToGreet(who: String) {
}

// Define Greeter Actor
class Greeter extends Actor {
  override def receive: Receive = {
    case WhoToGreet(who) => println(s"Hello $who")
  }
}

object HelloAkkaScala extends App {
  // create the 'hello akka' actor system
  val system = ActorSystem("Hello-Akka")

  // create the 'greeter' actor
  val greeter = system.actorOf(Props[Greeter], "greeter")

  // send WhoToGreet message to actor
  greeter ! WhoToGreet("Akka")
}