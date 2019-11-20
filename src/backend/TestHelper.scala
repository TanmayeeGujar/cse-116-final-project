package backend

import akka.actor.{Actor, ActorRef}
import backend._
import io.socket.client.{IO, Socket}
import io.socket.emitter.Emitter
import play.api.libs.json.{JsValue, Json}


class SocketClient(testActor: ActorRef) extends Actor {

  var socket: Socket = IO.socket("http://localhost:8080/")
  //  socket.on("gameState", new CheckGameState(this.self))
  socket.connect()
  socket.emit("register", Array("username", "password"))
  socket.emit("login", Array("username", "password"))

  override def receive: Receive = {
    case _ =>
  }

  override def postStop(): Unit = {
    println("closing socket")
    socket.close()
  }

}

//class CheckGameState(actor: ActorRef) extends Emitter.Listener {
//  override def call(objects: Object*): Unit = {
//    val jsonGameState = objects.apply(0).toString
//    val message: JsValue = Json.parse(jsonGameState)
//
//    var passed = true
//
//    // Add checks for the game state. Set passed to false if any checks fail
//    // Expect gold to be 3.0 in the provided example
//
//    actor ! Result(passed)
//  }
//}
