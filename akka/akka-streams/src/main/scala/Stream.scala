import java.util.concurrent.TimeUnit

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.{Flow, Sink, Source}

import scala.concurrent.Await
import scala.concurrent.duration.Duration

/**
  *
  * @author vsushko
  */
object Stream extends App {
  implicit val actorSystem = ActorSystem()
  implicit val fromMaterializer = ActorMaterializer()
  import actorSystem.dispatcher

  // source
  val input = Source(1 to 100)

  // flow
  val normalize = Flow[Int].map(_ * 2)

  // sink
  val output = Sink.foreach[Int](println)

  input.via(normalize).runWith(output).andThen {
    case _ =>
      actorSystem.terminate()
      Await.result(actorSystem.whenTerminated, Duration(1, TimeUnit.SECONDS))
  }
}
