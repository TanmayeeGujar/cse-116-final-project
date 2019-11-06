import akka.actor.{Actor, ActorRef}
import com.corundumstudio.socketio.{Configuration, SocketIOServer}

class ProjectServer(val database: ActorRef, configuration: String) extends Actor {

  val config: Configuration = new Configuration {
    setHostname("localhost")
    setPort(8080)
  }

  val server: SocketIOServer = new SocketIOServer(config)

  override def receive: Receive = { ???


  }

}
