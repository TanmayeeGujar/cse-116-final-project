import akka.actor.{Actor, ActorRef}
import akka.actor.{Actor, ActorSystem, Props}
import com.corundumstudio.socketio.{Configuration, SocketIOServer}

import scala.collection.script.Update
//import project.backend.Update

class ProjectServer(val database: ActorRef) extends Actor {

  val config: Configuration = new Configuration {
    setHostname("localhost")
    setPort(8080)
  }

  val server: SocketIOServer = new SocketIOServer(config)

  server.start()


  override def receive: Receive = { ???


  }

  override def postStop(): Unit = {
    println("stopping server")
    server.stop()
  }

}

object WebSocketServer {

  def main(args: Array[String]): Unit = {
    val actorSystem = ActorSystem()

    import actorSystem.dispatcher

    import scala.concurrent.duration._

    val server = actorSystem.actorOf(Props(classOf[ProjectServer]))

    actorSystem.scheduler.schedule(0.milliseconds, 33.milliseconds, server, (System.nanoTime()))
  }
}

