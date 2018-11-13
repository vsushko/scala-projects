import MusicController.{Play, Stop}
import MusicPlayer.{StartMusic, StopMusic}
import akka.actor.{Actor, ActorSystem, Props}

/**
  *
  * @author vsushko
  */
// Music Controller Messages
object MusicController {

  sealed trait ControllerMsg

  case object Play extends ControllerMsg

  case object Stop extends ControllerMsg

  def props = Props[MusicController]

}

// Music Controller
class MusicController extends Actor {
  def receive = {
    case Play =>
      println("Music Started ....")
    case Stop =>
      println("Music Stopped ....")
  }
}

// Music Player Messages
object MusicPlayer {

  sealed trait PlayMsg

  case object StopMusic extends PlayMsg

  case object StartMusic extends PlayMsg

}

// Music Player
class MusicPlayer extends Actor {
  override def receive: Receive = {
    case StopMusic =>
      println("I don't want to stop music")
    case StartMusic =>
      val controller = context.actorOf(MusicController.props, "controller")
      controller ! Play
    case _ =>
      println("Unknown Message")
  }
}

object Creation extends App {
  // create the 'creation actor system
  val system = ActorSystem("creation")

  // create the 'MusicPlayer' actor
  val player = system.actorOf(Props[MusicPlayer], "player")

  // send StartMusic Message to actor
  player ! StartMusic

  // send StopMusic Message to actor

  // shutdown system

}

object ActorCreation {

}
