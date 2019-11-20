package backend

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import com.corundumstudio.socketio.{Configuration, SocketIOServer}
import play.api.libs.json.JsValue
import com.corundumstudio.socketio.listener.{ConnectListener, DataListener, DisconnectListener}
import com.corundumstudio.socketio.{AckRequest, Configuration, SocketIOClient, SocketIOServer}



// Battle
case class Update(timestamp: Long)
case object ImReady
case class ATBStatus(percentFull: Double)
case class TurnAction(sourcePartyId: String,sourceName: String, targetName: String, action: String)
case class AnimateAction(sourcePartyId:String, sourceName: String, targetPartyId:String, targetName: String, deltaHP: Int)
case class CharacterTurnReady(partyId: String, characterName: String)
case class PartyLevel(partyId: String, level: Int)

// Battle System
case class AddParty(partyId: String, partyJSON: String)
case class PartyState(partyID: String, partyJSON: String)
case class RemoveParty(partyId: String)
case class BattleStarted(partyId1: String, partyId2: String)
case class BattleState(partyId1:String, partyJSON1: JsValue, partyId2:String, partyJSON2: JsValue)


// Over world
case class BattleEnded(winningPartyId: String, losingPartyId: String)
case class MoveParty(partyId: String, x: Double, y: Double)
case class StopParty(partyId: String)
case class OverworldMap(mapJSON: String)
case class OverworldState(overworldStateJSON: String)



// Authentication
case class Register(username: String, password: String)
case class RegistrationResult(username: String, registered: Boolean, message: String)
case class Login(username: String, password: String)
case class SaveGame(username: String, charactersJSON: String)
case class FailedLogin(username: String, message: String)
case class Authenticated(username: String, charactersJSON: String)

class WebSocketServer() extends Actor {

  var authenticationSystem: ActorRef = context.actorOf(Props(classOf[AuthenticationSystem]))
  var battle: ActorRef = context.actorOf(Props(classOf[BattleSystem], this.sender()))
  var overworld: ActorRef = context.actorOf(Props(classOf[OverworldSystem], this.sender()))

  var usernameToSocket: Map[String, SocketIOClient] = Map()
  var socketToUsername: Map[SocketIOClient, String] = Map()
  var UsernameToActorRef: Map[String, ActorRef] = Map()
  var ActorRefToUsername: Map[ActorRef, String] = Map()
  var StateTracker: Map[SocketIOClient, String] = Map()

  val config: Configuration = new Configuration {
    setHostname("localhost")
    setPort(8080)
  }

  val server: SocketIOServer = new SocketIOServer(config)

  class ConnectionListener() extends ConnectListener {
    def onConnect(client: SocketIOClient): Unit = {
      StateTracker += (client -> "Connected, not logged in")

      println("Connected: " + client)
    }
  }

  class DisconnectionListener() extends DisconnectListener {
    def onDisconnect(socket: SocketIOClient): Unit = {
      //       var party2beRemoved: String = socketToUsername(socket)
      //        battle ! RemoveParty(party2beRemoved)
      //       overworld ! RemoveParty(party2beRemoved)
      //       StateTracker(socket) = "Disconnected"
      //         println("Disconnected: " + socket)

    }
  }

  //    class RegisterListener(server: WebSocketServer) extends DataListener[String] {
  //      override def onData(socket: SocketIOClient, data: String, ackRequest: AckRequest): Unit = {
  //      if(StateTracker(socket) == "Connected, not logged in"){
  //        authenticationSystem ! Register(data, data)
  //      }
  ////       //    println(username + " registered in the chat with socket " + socket)
  ////       server.socketToUsername += (socket -> username)
  ////       server.usernameToSocket += (username -> socket)
  ////       val reference = context.actorOf(Props(classOf[GameActor], username, server.database))
  ////       //      reference
  ////       UsernameToActorRef += (username -> reference)
  ////       ActorRefToUsername += (reference -> username)
  ////
  ////       //    socket.sendEvent("dm", server.chatHistoryJSON())
  //     }
  //   }
  //
  //   class MovementListener(server: WebSocketServer) extends DataListener[Double]{
  //     override def onData(socket: SocketIOClient, data: Double, ackRequest: AckRequest): Unit = {
  //
  //     }
  //   }


  server.addConnectListener(new ConnectionListener())
  server.addDisconnectListener(new DisconnectionListener())
  //   server.addListeners(new RegisterListener(this))
  //   server.addEventListener("register", classOf[String] , new RegisterListener(this))



  server.start()

  override def receive: Receive = {

    //       case rec: Register =>
    //           authenticationSystem ! Register(rec.username, rec.password)
    //       case recres: RegistrationResult

    //       case os: OverworldState =>
    //         for((k,v) <- StateTracker){
    //           if( v == "in battle"){
    //             k.sendEvent(os.overworldStateJSON)
    //           }
    //         }
    case update: Update =>
      battle ! Update(System.nanoTime())
      overworld ! Update(System.nanoTime())


    case bstarted: BattleStarted =>
      println(bstarted.partyId1 + " and " + bstarted.partyId2 + " in battle")
      battle ! BattleStarted(bstarted.partyId1, bstarted.partyId2)


    case bended: BattleEnded =>
      overworld ! BattleEnded(bended.winningPartyId, bended.losingPartyId)
      println(bended.winningPartyId + " wins, State: in overworld")


    case bsjson: BattleState =>
      var p1 = usernameToSocket(bsjson.partyId1)
      p1.sendEvent(bsjson.partyJSON1.toString())
      var p2 = usernameToSocket(bsjson.partyId2)
      p2.sendEvent(bsjson.partyJSON2.toString())


    case owsjson: OverworldMap =>
      var mspJS:String = owsjson.mapJSON
      for((k,v) <- usernameToSocket){
        usernameToSocket(k).sendEvent(mspJS)
      }


    case owjson: OverworldState =>
      for((k,v) <- usernameToSocket){
        usernameToSocket(k).sendEvent(owjson.overworldStateJSON)
      }


    case charturnready: CharacterTurnReady =>
      var tosend: ActorRef = UsernameToActorRef(charturnready.partyId)
      tosend ! CharacterTurnReady(charturnready.partyId, charturnready.characterName)


    case json: PartyState =>
      authenticationSystem ! PartyState(json.partyID, json.partyJSON)
      usernameToSocket -= json.partyID


    case regrec: RegistrationResult =>
      //         var soc = usernameToSocket(regrec.username)
      if(regrec.registered){
        //           soc.sendEvent("message", regrec.message)
        println("Successfully registered")
      }
      else{
        //           soc.sendEvent("message", regrec.message)
        println("Registration failed")
      }


    case register: Register =>
      overworld ! Register(register.username, register.password)


    case login: Login =>
      overworld ! Login(login.username, login.password)


    case failloginrec: FailedLogin =>
      println("login failed : " + failloginrec.message)


    case authenticated: Authenticated =>
      println("successfully logged in")


  }

  override def postStop(): Unit = {
    //      println("stopping server")
    //      server.stop()
  }



}


object WebSocketServer {

  def main(args: Array[String]): Unit = {
    val actorSystem = ActorSystem()

    import actorSystem.dispatcher

    import scala.concurrent.duration._
    val server = actorSystem.actorOf(Props(classOf[WebSocketServer]))




    actorSystem.scheduler.schedule(0.milliseconds, 33.milliseconds, server, Update(System.nanoTime()))
  }
}


