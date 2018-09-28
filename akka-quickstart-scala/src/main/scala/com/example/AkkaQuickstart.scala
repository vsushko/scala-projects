package com.example

import akka.actor.{Actor, ActorLogging, ActorRef, ActorSystem, Props}

/**
  * The Greeter companion object
  */
object Greeter {
  // specifies options for the creation of actors
  def props(message: String, printerActor: ActorRef): Props = Props(new Greeter(message, printerActor))

  final case class WhoToGreet(who: String)

  case object Greet

}

/**
  * The Greeter actor implementation
  *
  * @param message      for greeting messages construction
  * @param printerActor reference of handling the output
  */
class Greeter(message: String, printerActor: ActorRef) extends Actor {

  import Greeter._
  import Printer._

  /**
    * Contains actor state
    */
  var greeting = ""

  /**
    * Handles the messages which actor expects
    */
  def receive = {
    case WhoToGreet(who) =>
      greeting = message + ", " + who
    case Greet =>
      // send message
      printerActor ! Greeting(greeting)
  }
}

/**
  * The printer companion object
  */
object Printer {
  def props: Props = Props[Printer]

  final case class Greeting(greeting: String)

}

/**
  * The Printer actor implementation
  */
class Printer extends Actor with ActorLogging {

  import Printer._

  /**
    * Handles the messages which actor expects and logs content of this message
    */
  def receive = {
    case Greeting(greeting) =>
      log.info("Greeting received (from " + sender() + "): " + greeting)
  }
}

object AkkaQuickstart extends App {

  import Greeter._

  // Create the 'helloAkka' actor system
  val system: ActorSystem = ActorSystem("helloAkka")

  // Create the printer actor
  val printer: ActorRef = system.actorOf(Printer.props, "printerActor")

  // Create the 'greeter' actors
  val howdyGreeter: ActorRef = system.actorOf(Greeter.props("Howdy", printer), "howdyGreeter")
  val helloGreeter: ActorRef = system.actorOf(Greeter.props("Hello", printer), "helloGreeter")
  val goodDayGreeter: ActorRef = system.actorOf(Greeter.props("Good day", printer), "goodDayGreeter")

  //#main-send-messages
  howdyGreeter ! WhoToGreet("Akka")
  howdyGreeter ! Greet

  howdyGreeter ! WhoToGreet("Lightbend")
  howdyGreeter ! Greet

  helloGreeter ! WhoToGreet("Scala")
  helloGreeter ! Greet

  goodDayGreeter ! WhoToGreet("Play")
  goodDayGreeter ! Greet
  //#main-send-messages
}

