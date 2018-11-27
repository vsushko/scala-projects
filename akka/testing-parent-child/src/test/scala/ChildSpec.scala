import akka.actor.{ActorSystem, Props}
import akka.testkit.{ImplicitSender, TestKit, TestProbe}
import org.scalatest.{BeforeAndAfterAll, FlatSpecLike, MustMatchers}

/**
  *
  * @author vsushko
  */
class ChildSpec extends TestKit(ActorSystem("test-system"))
  with ImplicitSender
  with FlatSpecLike
  with BeforeAndAfterAll
  with MustMatchers {

  override def afterAll(): Unit = {
    TestKit.shutdownActorSystem(system)
  }

  "Child Actor" should "send pong message when receive ping message" in {
    val parent = TestProbe()
    val child = system.actorOf(Props(new Child(parent.ref)))
    child ! "ping"
    parent.expectMsg("pong")
  }
}