package loadbalancing

import akka.cluster._
import com.typesafe.config.ConfigFactory
import akka.cluster.ClusterEvent.MemberUp
import akka.actor.{Actor, ActorRef, ActorSystem, Props, RootActorPath}
import commons.Add

/**
  *
  * @author vsushko
  */
class Backend extends Actor {

  def receive: Receive = {
    case Add(num1, num2) =>
      println(s"I'm a backend with path: ${self} and I received add operation.")
  }
}

object Backend {
  def initiate(port: Int) {
    val config = ConfigFactory.parseString(s"akka.remote.netty.tcp.port=$port").
      withFallback(ConfigFactory.parseString("akka.cluster.roles = [backend]")).
      withFallback(ConfigFactory.load("loadbalancer"))

    val system = ActorSystem("ClusterSystem", config)
    val Backend = system.actorOf(Props[Backend], name = "backend")
  }
}