package View

import io.socket.client.{IO, Socket}
import io.socket.emitter.Emitter
import javafx.application.Platform
import javafx.event.ActionEvent
import scalafx.animation.AnimationTimer
import scalafx.scene.control.Button
import scalafx.scene.layout.StackPane
import scalafx.scene.paint.Color
import scalafx.scene.shape.{Circle, Rectangle}
//import javafx.scene.control.Button
import javafx.scene.layout.VBox
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.{Scene, control}
//import scalafx.scene.control.Button
import play.api.libs.json.{JsValue, Json}
import scalafx.scene.control.TextField
import main.Party
import main.Character1
import main.Character2
import main.Character




//class HandleMessagesFromServer() extends Emitter.Listener {

//  def takeTurn(player: String): Unit = {
//    if(player == "Eleonora"){
//      DesktopBattleGUI.player1
//    }

//  override def call(objects: Object*): Unit = {
//
//    Platform.runLater(() => {
//      val update1: Update = new Update
//      val jsonGameState = update1.createJSON()
//      val parsed: JsValue = Json.parse(jsonGameState)
//
//      val playerPartyChars: List[JsValue] = ((parsed\"playerParty")\"characters").as[List[JsValue]]
//      val enemyPartyChars: List[JsValue] = ((parsed\"enemyParty")\"characters").as[List[JsValue]]
//      val player1json = playerPartyChars(0).as[JsValue]
//      val player2json = playerPartyChars(1).as[JsValue]
//      val player3json = playerPartyChars(2).as[JsValue]
//      val player4json = playerPartyChars(3).as[JsValue]
////      val parsed1 : JsValue = Json.parse(player1json)
//      val player1name: String = (player1json\"name").as[String]
////      val parsed2 : JsValue = Json.parse(player2json)
//      val player2name: String = (player2json\"name").as[String]
////      val parsed3 : JsValue = Json.parse(player3json)
//     val player3name: String = (player3json\"name").as[String]
////      val parsed4 : JsValue = Json.parse(player4json)
//      val player4name: String = (player4json\"name").as[String]
////      DesktopBattleGUI.player1.accessibleText = player1name
////      DesktopBattleGUI.player2.accessibleText = player2name
////      DesktopBattleGUI.player3.accessibleText = player3name
////      DesktopBattleGUI.player4.accessibleText = player4name
//      val player1hp = (player1json\"hp").as[Int]
//      val player2hp = (player2json\"hp").as[Int]
//      val player3hp = (player3json\"hp").as[Int]
//      val player4hp = (player4json\"hp").as[Int]
////      val enemy1hp = (parsed4\"hp").as[Int]
//      if(player1hp == 0){
//        DesktopBattleGUI.player1.fill = Color.Grey
//      }
//      if(player2hp == 0){
//        DesktopBattleGUI.player2.fill = Color.Red
//      }
//      if(player3hp == 0){
//        DesktopBattleGUI.player3.fill = Color.Red
//      }
//      if(player4hp <= 0){
//        DesktopBattleGUI.player4.fill = Color.Red
//      }
//
//      DesktopBattleGUI.Ele.onAction = (event: ActionEvent) => DesktopBattleGUI.pl = "Eleonora"
//      DesktopBattleGUI.Ed.onAction = (event: ActionEvent) => DesktopBattleGUI.pl = "Edoardo"
//      DesktopBattleGUI.Gio.onAction = (event: ActionEvent) => DesktopBattleGUI.pl = "Giovanni"
//      DesktopBattleGUI.Chris.onAction = (event: ActionEvent) => DesktopBattleGUI.pl = "Christopher"
//
////      DesktopBattleGUI.txt = DesktopBattleGUI.takeTurn(DesktopBattleGUI.pl)
//
////      println(player1name)
//    })
//  }
//}




























//object DesktopBattleGUI extends JFXApp{
//
//  def update(js: String) : Unit = {
//    Platform.runLater(() => {
//      val update1: Update = new Update
//      val jsonGameState = update1.createJSON()
//      val parsed: JsValue = Json.parse(jsonGameState)
//
//      val playerPartyChars: List[Map[String, Any]] = ((parsed\"playerParty")\"characters").as[List[Map[String, Any]]]
//      val enemyPartyChars: List[JsValue] = ((parsed\"enemyParty")\"characters").as[List[JsValue]]
//      val player1json = playerPartyChars(0).as[JsValue]
//      val player2json = playerPartyChars(1).as[JsValue]
//      val player3json = playerPartyChars(2).as[JsValue]
//      val player4json = playerPartyChars(3).as[JsValue]
//      //      val parsed1 : JsValue = Json.parse(player1json)
//      val player1name: String = (player1json\"name").as[String]
//      //      val parsed2 : JsValue = Json.parse(player2json)
//      val player2name: String = (player2json\"name").as[String]
//      //      val parsed3 : JsValue = Json.parse(player3json)
//      val player3name: String = (player3json\"name").as[String]
//      //      val parsed4 : JsValue = Json.parse(player4json)
//      val player4name: String = (player4json\"name").as[String]
//      //      DesktopBattleGUI.player1.accessibleText = player1name
//      //      DesktopBattleGUI.player2.accessibleText = player2name
//      //      DesktopBattleGUI.player3.accessibleText = player3name
//      //      DesktopBattleGUI.player4.accessibleText = player4name
//      val player1hp = (player1json\"hp").as[Int]
//      val player2hp = (player2json\"hp").as[Int]
//      val player3hp = (player3json\"hp").as[Int]
//      val player4hp = (player4json\"hp").as[Int]
//      //      val enemy1hp = (parsed4\"hp").as[Int]
//      if(player1hp == 0){
//        DesktopBattleGUI.player1.fill = Color.Grey
//      }
//      if(player2hp == 0){
//        DesktopBattleGUI.player2.fill = Color.Red
//      }
//      if(player3hp == 0){
//        DesktopBattleGUI.player3.fill = Color.Red
//      }
//      if(player4hp <= 0){
//        DesktopBattleGUI.player4.fill = Color.Red
//      }
//
//      DesktopBattleGUI.Ele.onAction = (event: ActionEvent) => DesktopBattleGUI.pl = "Eleonora"
//      DesktopBattleGUI.Ed.onAction = (event: ActionEvent) => DesktopBattleGUI.pl = "Edoardo"
//      DesktopBattleGUI.Gio.onAction = (event: ActionEvent) => DesktopBattleGUI.pl = "Giovanni"
//      DesktopBattleGUI.Chris.onAction = (event: ActionEvent) => DesktopBattleGUI.pl = "Christopher"
//
//      //      DesktopBattleGUI.txt = DesktopBattleGUI.takeTurn(DesktopBattleGUI.pl)
//
//      //      println(player1name)
//    })
//  }
//}
//  }
//
//  var lastUpdateTime: Long = System.nanoTime()
//
//
//
////  var socket: Socket = IO.socket("https://tictactoe.info/")
////  socket.on("gameState", new HandleMessagesFromServer)
////  socket.connect()
////
////  // Change "test" to any username you'd like to start a new game
////  socket.emit("register", "hdwushwfkausc")
//
//  var pl: String = ""
//
//  val windowWidth: Double = 800
//  val windowHeight: Double = 600
//
//  val player1: Circle = new Circle {
//    centerX = 50.0
//    centerY = 50.0
//    radius = 20.0
//    fill = Color.Blue
//  }
//  val Ele: Button = new Button{
//    style = "-fx-font: 18 ariel;"
//    text = "Eleonora"
//    translateY = 70.0
//    translateX = 10.0
//    minWidth = 30.0
//    minHeight = 20.0
//    pl = "Eleonora"
//    onAction = (event: ActionEvent) => update1.takeTurn("Eleonora")
//
//  }
//  val player2: Circle = new Circle {
//    centerX = 45.0
//    centerY = 50.0
//    radius = 10.0
//    fill = Color.Blue
//  }
//  val Ed: Button = new Button{
//    style = "-fx-font: 18 ariel;"
//    text = "Edoardo"
//    translateY = 110.0
//    translateX = 10.0
//    minWidth = 30.0
//    minHeight = 20.0
//    pl = "Edoardo"}
//  val player3: Circle = new Circle {
//    centerX = 70.0
//    centerY = 50.0
//    radius = 10.0
//    fill = Color.Blue
//  }
//
//  val Gio: Button = new Button{
//    style = "-fx-font: 18 ariel;"
//    text = "Giovanni"
//    translateY = 150.0
//    translateX = 10.0
//    minWidth = 30.0
//    minHeight = 20.0
//    pl = "Giovanni"}
//  val player4: Circle = new Circle {
//    centerX = 95.0
//    centerY = 50.0
//    radius = 10.0
//    fill = Color.Blue
//  }
//
//  val Chris: Button = new Button{
//    style = "-fx-font: 18 ariel;"
//    text = "Christopher"
//    translateY = 190.0
//    translateX = 10.0
//    minWidth = 30.0
//    minHeight = 20.0
//    pl= "Christopher"}
//
//  val enemy1: Rectangle = new Rectangle {
//    width = 20.0
//    height = 20.0
//    translateX = 120.0
//    translateY = 40.0
//    fill = Color.Blue
//  }
//
//  val txt: TextField = new TextField{
//    style = "-fx-font: 18 ariel;"
//    translateX = 70.0
//    translateY = 70.0
//  }
//  val enemy2: Rectangle = new Rectangle {
//    width = 20.0
//    height = 20.0
//    translateX = 150.0
//    translateY = 40.0
//    fill = Color.Blue
//  }
//  val enemy3: Rectangle = new Rectangle {
//    width = 20.0
//    height = 20.0
//    translateX = 180.0
//    translateY = 40.0
//    fill = Color.Blue
//  }
//  val enemy4: Rectangle = new Rectangle {
//    width = 20.0
//    height = 20.0
//    translateX = 210.0
//    translateY = 40.0
//    fill = Color.Blue
//  }
//  val PhysicalAttack: Button = new Button {
//    minWidth= 500
//    minHeight = 100
//    translateX = 100.0
//    translateY = 10.0
//    style= "-fx-font: 12 ariel;"
//    text = "Physical Attack"
////    onAction = (event: ActionEvent) => Character1.
//    }
//
////  def takeTurn(player: String): Unit = {
////    if(player == "Eleonora"){
////      DesktopBattleGUI.player1
////    }
//
//
//
////  sceneGraphics.children.add(player)
//  this.stage = new PrimaryStage {
//    this.title = "2D Graphics"
//    scene = new Scene(windowWidth, windowHeight) {
//      content = List(player1, player2, player3, player4, enemy1, enemy2, enemy3, enemy4, Ele, Ed, Gio, Chris) }
////    val update: Long => Unit = (time: Long) => { for (shape <- allRectangles) {
////      shape.rotate.value += 0.5
//    val update: Long => Unit = (time: Long) => {
//  val dt: Double = (time - lastUpdateTime) / 1000000000.0
//  lastUpdateTime = time
////  game.update(dt)
//  if(pl == "Eleonora"){
//    player1.fill = Color.Yellow
//
//  }
//  else if(pl == "Edoaedo"){
//  player2.fill = Color.Yellow}
//
//    else if(pl == "Giovanni"){
//      player3.fill = Color.Yellow
//    }
//    else if(pl == "Christopher"){
//      player4.fill = Color.Yellow
//    }}}
//
//    AnimationTimer(update).start() }
////    }
////    AnimationTimer(update).start() }
//
//
//
//
