package backend

import akka.actor.{ActorSystem, Props}
import akka.testkit.{ImplicitSender, TestKit}
import backend._

import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}

import scala.concurrent.duration._


class TestingServer extends TestKit(ActorSystem("TestServer"))
  with ImplicitSender
  with WordSpecLike
  with Matchers
  with BeforeAndAfterAll {

  override def afterAll: Unit = {
    TestKit.shutdownActorSystem(system)
  }



  //  "A Server communicating with Authentication" must {
  //    "communicate with authentication system for registration" in {
  //
  //
  //      val server = system.actorOf(Props(classOf[WebSocketServer]))
  //      val authentication = system.actorOf(Props(classOf[AuthenticationSystem]))
  //      val battle = system.actorOf(Props(classOf[BattleSystem], server))
  //      val overworld = system.actorOf(Props(classOf[OverworldSystem], server))
  //
  //      // Wait for the server to start
  //      expectNoMessage(10000.millis)
  //
  //      server ! RegistrationResult("user", true, "successfully registered")
  //      val client = system.actorOf(Props(classOf[SocketClient], this.testActor))
  //      expectNoMessage(1000.millis)
  //
  //      server ! FailedLogin
  //
  //
  //
  //    }
  //
  //    "communicate with authentication system for failed login" in {
  //
  //
  //      val server = system.actorOf(Props(classOf[WebSocketServer]))
  //      val authentication = system.actorOf(Props(classOf[AuthenticationSystem]))
  //      val battle = system.actorOf(Props(classOf[BattleSystem], server))
  //      val overworld = system.actorOf(Props(classOf[OverworldSystem], server))
  //
  //      // Wait for the server to start
  //      expectNoMessage(10000.millis)
  //      server ! FailedLogin("username", "failed because password didn't meet criteria")
  //
  //      val client = system.actorOf(Props(classOf[SocketClient], this.testActor))
  //      expectNoMessage(1000.millis)
  //
  //
  //
  //
  //    }
  //
  //    "communicate with authentication system for successful login" in {
  //
  //
  //      val server = system.actorOf(Props(classOf[WebSocketServer]))
  //      val authentication = system.actorOf(Props(classOf[AuthenticationSystem]))
  //      val battle = system.actorOf(Props(classOf[BattleSystem], server))
  //      val overworld = system.actorOf(Props(classOf[OverworldSystem], server))
  //
  //      // Wait for the server to start
  //      expectNoMessage(10000.millis)
  //      server ! Authenticated("user", "partyJSON")
  //
  //      val client = system.actorOf(Props(classOf[SocketClient], this.testActor))
  //      expectNoMessage(1000.millis)
  //
  //
  //
  //
  //    }
  //
  //
  //
  //  }


  "A Server communicating with Battle" must {
    //    "communicate with battle system for start of battle" in {
    //
    //
    //      val server = system.actorOf(Props(classOf[WebSocketServer]))
    //      val authentication = system.actorOf(Props(classOf[AuthenticationSystem]))
    //      val battle = system.actorOf(Props(classOf[BattleSystem], server))
    //      val overworld = system.actorOf(Props(classOf[OverworldSystem], server))
    //
    //      // Wait for the server to start
    //      expectNoMessage(10000.millis)
    //
    //      server ! BattleStarted("party1", "party2")
    //
    //      val client = system.actorOf(Props(classOf[SocketClient], this.testActor))
    //      expectNoMessage(1000.millis)
    //
    //
    //
    //
    //    }

    "communicate with battle system for end of battle" in {


      val server = system.actorOf(Props(classOf[WebSocketServer]))
      val authentication = system.actorOf(Props(classOf[AuthenticationSystem]))
      val battle = system.actorOf(Props(classOf[BattleSystem], server))
      val overworld = system.actorOf(Props(classOf[OverworldSystem], server))

      // Wait for the server to start
      expectNoMessage(10000.millis)

      server ! BattleEnded("party1", "party2")


      val client = system.actorOf(Props(classOf[SocketClient], this.testActor))
      expectNoMessage(1000.millis)




    }





  }



}
