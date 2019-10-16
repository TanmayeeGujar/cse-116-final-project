package View

//import io.socket.client.{IO, Socket}
//import io.socket.emitter.Emitter
//import javafx.application.Platform
//import javafx.event.ActionEvent
//import scalafx.animation.AnimationTimer
//import scalafx.scene.control.Button
//import scalafx.scene.layout.StackPane
//import scalafx.scene.paint.Color
//import scalafx.scene.shape.{Circle, Rectangle}
////import javafx.scene.control.Button
//import javafx.scene.layout.VBox
//import scalafx.application.JFXApp
//import scalafx.application.JFXApp.PrimaryStage
//import scalafx.scene.{Scene, control}
////import scalafx.scene.control.Button
//import play.api.libs.json.{JsValue, Json}
//import scalafx.scene.control.TextField
//import main.Party
//import main.Character1
//import main.Character2
//import main.Character
//
//class Update {
//
//  val Eleonora: Character1 = new Character1
//  val Edoardo: Character2 = new Character2
//  val Giovanni: Character1 = new Character1
//  val Christopher: Character2 = new Character2
//
//  def createJSON(): String = {
//    //    val Eleonora: Character1 = new Character1
//    val player1name: String = "Eleonora"
////    val player1nameJs: JsValue = Json.toJson(player1name)
//    val player1hp: Int = Eleonora.currentHP
//    val player1hpJs: JsValue = Json.toJson(player1hp)
//    val player1mp: Int = Eleonora.currentMP
//    val player1mpJs: JsValue = Json.toJson(player1mp)
////    val player1BO: List[String] = Eleonora.battleOptions()
//    val player1BO : List[String] = List("Physical Attack", "Magic Attack", "Spell", "Heal")
//    val player1BOJs: JsValue = Json.toJson(player1BO)
//    val player1map: Map[String, Any] = Map("name" -> player1name, "hp" -> player1hp, "mp" -> player1mp, "battleOptions" -> player1BO)
//    val player1json: JsValue = Json.toJson(player1map)
//
//    //    val Edoardo: Character2 = new Character2
//    val player2name: String = "Edoardo"
//    val player2nameJs: JsValue = Json.toJson(player2name)
//    val player2hp: Int = Edoardo.currentHP
//    val player2hpJs: JsValue = Json.toJson(player2hp)
//    val player2mp: Int = Edoardo.currentMP
//    val player2mpJs: JsValue = Json.toJson(player2mp)
////    val player2BO: List[String] = Edoardo.battleOptions()
//val player2BO : List[String] = List("Physical Attack", "Magic Attack", "Spell", "Heal")
//    val player2BOJs: JsValue = Json.toJson(player2BO)
//    val player2map: Map[String, JsValue] = Map("name" -> player2nameJs, "hp" -> player2hpJs, "mp" -> player2mpJs, "battleOptions" -> player2BOJs)
//    val player2json: JsValue = Json.toJson(player2map)
//
//    //    val Giovanni: Character1 = new Character1
//    val player3name: String = "Giovanni"
//    val player3nameJs: JsValue = Json.toJson(player3name)
//    val player3hp: Int = Giovanni.currentHP
//    val player3hpJs: JsValue = Json.toJson(player3hp)
//    val player3mp: Int = Giovanni.currentMP
//    val player3mpJs: JsValue = Json.toJson(player3mp)
////    val player3BO: List[String] = Giovanni.battleOptions()
//val player3BO : List[String] = List("Physical Attack", "Magic Attack", "Spell", "Heal")
//    val player3BOJs: JsValue = Json.toJson(player3BO)
//    val player3map: Map[String, JsValue] = Map("name" -> player3nameJs, "hp" -> player3hpJs, "mp" -> player3mpJs, "battleOptions" -> player3BOJs)
//    val player3json: JsValue = Json.toJson(player3map)
//
//    //    val Christopher: Character2 = new Character2
//    val player4name: String = "Christopher"
//    val player4nameJs: JsValue = Json.toJson(player4name)
//    val player4hp: Int = Christopher.currentHP
//    val player4hpJs: JsValue = Json.toJson(player4hp)
//    val player4mp: Int = Christopher.currentMP
//    val player4mpJs: JsValue = Json.toJson(player4mp)
////    val player4BO: List[String] = Christopher.battleOptions()
//val player4BO : List[String] = List("Physical Attack", "Magic Attack", "Spell", "Heal")
//    val player4BOJs: JsValue = Json.toJson(player4BO)
//    val player4map: Map[String, JsValue] = Map("name" -> player4nameJs, "hp" -> player4hpJs, "mp" -> player4mpJs, "battleOptions" -> player4BOJs)
//    val player4json: JsValue = Json.toJson(player4map)
//
//    val partyChars: List[JsValue] = List(player1json, player2json, player3json, player4json)
//
//    val playerMap = Map("characters" -> partyChars)
//
//    val playerJs: JsValue = Json.toJson(playerMap)
//
//
//    val Federico: Character1 = new Character1
//    val enemy1name: String = "Federico"
//    val enemy1nameJs: JsValue = Json.toJson(enemy1name)
//    val enemy1hp: Int = 0
//    val enemy1hpJs: JsValue = Json.toJson(enemy1hp)
//    val enemy1mp: Int = Federico.currentMP
//    val enemy1mpJs: JsValue = Json.toJson(enemy1mp)
//    val enemy1BO: List[String] = Federico.battleOptions()
//    val enemy1BOJs: JsValue = Json.toJson(enemy1BO)
//    val enemy1map: Map[String, JsValue] = Map("name" -> enemy1nameJs, "hp" -> enemy1hpJs, "mp" -> enemy1mpJs, "battleOptions" -> enemy1BOJs)
//    val enemy1json: JsValue = Json.toJson(enemy1map)
//
//    val Maya: Character2 = new Character2
//    val enemy2name: String = "Maya"
//    val enemy2nameJs: JsValue = Json.toJson(enemy2name)
//    val enemy2hp: Int = Maya.currentHP
//    val enemy2hpJs: JsValue = Json.toJson(enemy2hp)
//    val enemy2mp: Int = Maya.currentMP
//    val enemy2mpJs: JsValue = Json.toJson(enemy2mp)
//    val enemy2BO: List[String] = Maya.battleOptions()
//    val enemy2BOJs: JsValue = Json.toJson(enemy2BO)
//    val enemy2map = Map("name" -> enemy2nameJs, "hp" -> enemy2hpJs, "mp" -> enemy2mpJs, "battleOptions" -> enemy2BOJs)
//    val enemy2json: JsValue = Json.toJson(enemy2map)
//
//    val Sybil: Character1 = new Character1
//    val enemy3name: String = "Sybil"
//    val enemy3nameJs: JsValue = Json.toJson(enemy3name)
//    val enemy3hp: Int = Sybil.currentHP
//    val enemy3hpJs: JsValue = Json.toJson(enemy3hp)
//    val enemy3mp: Int = Sybil.currentMP
//    val enemy3mpJs: JsValue = Json.toJson(enemy3mp)
//    val enemy3BO: List[String] = Sybil.battleOptions()
//    val enemy3BOJs: JsValue = Json.toJson(enemy3BO)
//    val enemy3map = Map("name" -> enemy3nameJs, "hp" -> enemy3hpJs, "mp" -> enemy3mpJs, "battleOptions" -> enemy3BOJs)
//    val enemy3json: JsValue = Json.toJson(enemy3map)
//
//    val Felix: Character2 = new Character2
//    val enemy4name: String = "Felix"
//    val enemy4nameJs: JsValue = Json.toJson(enemy4name)
//    val enemy4hp: Int = Felix.currentHP
//    val enemy4hpJs: JsValue = Json.toJson(enemy4hp)
//    val enemy4mp: Int = Felix.currentMP
//    val enemy4mpJs: JsValue = Json.toJson(enemy4mp)
//    val enemy4BO: List[String] = Felix.battleOptions()
//    val enemy4BOJs: JsValue = Json.toJson(enemy4BO)
//    val enemy4map = Map("name" -> enemy4nameJs, "hp" -> enemy4hpJs, "mp" -> enemy4mpJs, "battleOptions" -> enemy4BOJs)
//    val enemy4json: JsValue = Json.toJson(enemy4map)
//
//    val enemyChars: List[JsValue] = List(enemy1json, enemy2json, enemy3json, enemy4json)
//
//    val EnemyMap = Map("characters" -> enemyChars)
//
//    val enemyJs: JsValue = Json.toJson(EnemyMap)
//
//    val PartyJS = Map("playerParty" -> playerJs, "enemyParty" -> enemyJs)
//
//    Json.stringify(Json.toJson(PartyJS))
//
//  }
//
////  def takeTurn(player: String): Any = {
////    if (player == "Eleonora") {
////      Eleonora.battleOptions()
////    }
////    else if (player == "Edoardo") {
////      Edoardo.battleOptions()
////    }
////    else if (player == "Giovanni") {
////      Giovanni.battleOptions()
////    }
////    else if (player == "Christopher") {
////      Christopher.battleOptions()
////    }
////  }
//
//
//}
