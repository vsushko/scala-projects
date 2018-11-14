import Checker._
import Recorder._
import Storage._
import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.pattern.ask
import akka.util.Timeout

import scala.concurrent.duration._
import scala.language.postfixOps


/**
  *
  * @author vsushko
  */

case class User(username: String, email: String)

object Recorder {

  sealed trait RecorderMsg

  // Recorder Messages
  case class NewUser(user: User) extends RecorderMsg

  def props(checker: ActorRef, storage: ActorRef) =
    Props(new Recorder(checker, storage))

}

class Recorder(checker: ActorRef, storage: ActorRef) extends Actor {
  import scala.concurrent.ExecutionContext.Implicits.global

  implicit val timeout = Timeout(5 seconds)

  def receive = {
    case NewUser(user) =>
      checker ? CheckUser(user) map {
        case WhiteUser(user) =>
          storage ! AddUser(user)
        case BlackUser(user) =>
          println(s"Recorder: $user in the blacklist")
      }
  }

}

object Checker {

  sealed trait CheckerMsg

  // Checker Messages
  case class CheckUser(user: User) extends CheckerMsg

  sealed trait CheckerResponse

  // Checker Responses
  case class BlackUser(user: User) extends CheckerMsg

  case class WhiteUser(user: User) extends CheckerMsg

}

class Checker extends Actor {

  val blackList = List(User("Adam", "adam@mail.com"))

  override def receive: Receive = {
    case CheckUser(user) if blackList.contains(user) =>
      println(s"Checker: $user in the blacklist")
      sender() ! BlackUser(user)
    case CheckUser(user) =>
      println(s"Checker: $user not in the blacklist")
      sender() ! WhiteUser(user)
  }
}

object Storage {

  sealed trait StorageMsg

  // Storage Messages
  case class AddUser(user: User) extends StorageMsg

}

class Storage extends Actor {

  var users = List.empty[User]

  def receive = {
    case AddUser(user) =>
      println(s"Storage: $user added")
      users = user :: users
  }
}

object TalkToActor extends App {
  // Crete the 'talk to actor' actor system
  val system = ActorSystem("talk-to-actor")

  // Create the 'checker' actor
  val checker = system.actorOf(Props[Checker], "checker")

  // Create the 'storage' actor
  val storage = system.actorOf(Props[Checker], "storage")

  // Create the 'recorder' actor
  val recorder = system.actorOf(Recorder.props(checker, storage), "recorder")

  // send NewUser message to Recorder
  recorder ! Recorder.NewUser(User("John", "jon@mail.com"))

  Thread.sleep(100)

  system.terminate()
}
