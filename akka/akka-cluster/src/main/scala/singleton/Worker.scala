package singleton

import akka.actor.{Actor, ActorLogging, Props}
import akka.cluster.singleton.{ClusterSingletonProxy, ClusterSingletonProxySettings}

import scala.concurrent.duration._

/**
  *
  * @author vsushko
  */
class Worker extends Actor with ActorLogging {

  import Master._
  import context.dispatcher

  val masterProxy = context.actorOf(ClusterSingletonProxy.props(
    singletonManagerPath = "/user/master",
    settings = ClusterSingletonProxySettings(context.system).withRole(None)
  ), name = "masterProxy")

  context.system.scheduler.schedule(0.second, 30.second, masterProxy, RegisterWorker(self))
  context.system.scheduler.schedule(3.second, 3.second, masterProxy, RequestWork(self))

  def receive = {
    case Work(requester, op) =>
      log.info(s"Worker: I received work with op: $op and I will reply to $requester.")
  }
}

object Worker {

  def props = Props(new Worker())
}