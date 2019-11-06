package View2

import play.api.libs.json.{JsValue, Json}
import main.Character1
import main.Character2
import scalafx.application.JFXApp
import javafx.application.Platform
import javafx.event.{ActionEvent, EventHandler}
import scalafx.animation.AnimationTimer
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.control.Button
import scalafx.scene.paint.Color
import scalafx.scene.shape.{Circle, Rectangle}
import scalafx.scene.control.TextField

class ButtonListener(st: String, hp: Int) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = {
    BattleDesktopGUI.HP = hp
    println(st)
  }}
class ButtonListener1(st: String, st1: String, rectangle: Rectangle) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = {
    BattleDesktopGUI.playerdealingdamage = st1
    println(st)
    rectangle.fill = Color.Orange
  }}
class ButtonListener2() extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = {
    BattleDesktopGUI.animate(BattleDesktopGUI.playertakingturn, BattleDesktopGUI.playerdealingdamage, BattleDesktopGUI.HP)
  }}

class ButtonListener3() extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = {
       BattleDesktopGUI.takeTurn("Gio")
//    BattleDesktopGUI.takeTurn("Ele")
  }}

class ButtonListener4(st: String) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = {
    BattleDesktopGUI.playertakingturn = st
   BattleDesktopGUI.takeTurn(st)
  }}




object BattleDesktopGUI extends JFXApp{

  var HP : Int = 0
  var playertakingturn: String = ""
  var playerdealingdamage: String = ""

  def createJSON(): String = {
    val Eleonora: Character1 = new Character1
    val Giovanni: Character2 = new Character2
    val Felix: Character1 = new Character1
    val Maya: Character2 = new Character2

    val elehp: JsValue = Json.toJson(0)
    val elemaxhp: JsValue = Json.toJson(Eleonora.maxHP)
    val elebo: JsValue = Json.toJson(List("Physical Attack", "Magic Attack", "Spell", "Heal"))
    val elemap: JsValue = Json.toJson(Map("name" -> Json.toJson("Ele"), "hp" -> elehp, "maxHP" -> elemaxhp, "battleOptions" -> elebo))
    val giohp: JsValue = Json.toJson(Giovanni.currentHP)
    val giomaxhp: JsValue = Json.toJson(Giovanni.maxHP)
    val giobo: JsValue = Json.toJson(List("Physical Attack", "Magic Attack", "Spell", "Heal"))
    val giomap: JsValue = Json.toJson(Map("name" -> Json.toJson("Gio"), "hp" -> giohp, "maxHP" -> giomaxhp, "battleOptions" -> giobo))
    val playerlist : JsValue = Json.toJson(List(elemap, giomap))
    val playermap : JsValue = Json.toJson(Map("characters" -> playerlist))

    val felhp: JsValue = Json.toJson(Felix.currentHP)
    val felmaxhp: JsValue = Json.toJson(Felix.maxHP)
    val felbo: JsValue = Json.toJson(List("Physical Attack", "Magic Attack", "Spell", "Heal"))
    val felmap: JsValue = Json.toJson(Map("name" -> Json.toJson("Fel"), "hp" -> felhp, "maxHP" -> felmaxhp, "battleOptions" -> felbo))
    val mayhp: JsValue = Json.toJson(Maya.currentHP)
    val maymaxhp: JsValue = Json.toJson(Maya.maxHP)
    val maybo: JsValue = Json.toJson(List("Physical Attack", "Magic Attack", "Spell", "Heal"))
    val maymap: JsValue = Json.toJson(Map("name" -> Json.toJson("May"), "hp" -> mayhp, "maxHP" -> maymaxhp, "battleOptions" -> maybo))
    val enemylist : JsValue = Json.toJson(List(felmap, maymap))
    val enemymap : JsValue = Json.toJson(Map("characters" -> enemylist))

    val map: JsValue = Json.toJson(Map("playerParty" -> playermap, "enemyParty" -> enemymap))
    Json.stringify(map)
  }

  /** Uncomment this to demo that def createJson() returns the correct Json string */
  override def main(args: Array[String]): Unit = {
    println(createJSON())
  }

  val JSstr = createJSON()
  var lastUpdateTime = System.nanoTime()
  var newfelhp: Int = 0
  var newmayhp: Int = 0

  def update(JSstr: String) : Unit = {
    Platform.runLater(() => {
      val parsed = Json.parse(JSstr)

      val playerList: List[JsValue] = ((parsed\"playerParty")\"characters").as[List[JsValue]]
      val elejs: JsValue = playerList(0)
      val giojs: JsValue = playerList(1)
      val ele: String = (elejs\"name").as[String]

      /** comment out either line 107 or 108 to show how colour of shape depends on HP */

//      val newelehp: Int = (elejs\"hp").as[Int]
      val newelehp : Int = 5
      val newelebo: List[String] = (elejs\"battleOptions").as[List[String]]
      val gio: String = (giojs\"name").as[String]
      val newgiohp: Int = (giojs\"hp").as[Int]
      val newgiobo: List[String] = (giojs\"battleOptions").as[List[String]]

      val enemyList: List[JsValue] = ((parsed\"enemyParty")\"characters").as[List[JsValue]]
      val feljs: JsValue = enemyList(0)
      val mayjs: JsValue = enemyList(1)

      /** comment out either line 120 or 121 to show how Fel changes colour after dealing damage depending on if it was fatal*/

      val fel: String = (feljs\"name").as[String]
//      newfelhp= (feljs\"hp").as[Int]
      newfelhp = 3
      val newfelbo: List[String] = (feljs\"battleOptions").as[List[String]]
      val may: String = (mayjs\"name").as[String]
      newmayhp= (mayjs\"hp").as[Int]
      val newmaybo: List[String] = (mayjs\"battleOptions").as[List[String]]

      eletext.text = ele + ", HP = " + newelehp
      giotext.text = gio + ", HP = " + newgiohp
      PhysicalAttack.text = newelebo(0)
      MagicAttack.text = newelebo(1)
      Spell.text = newelebo(2)
      Heal.text = newelebo(3)
      feltext.text = "HP = " + newfelhp
      maytext.text = "HP = " + newmayhp
      if(newelehp == 0){
        eledot.fill = Color.Gray
      }
      else if(newgiohp == 0){
        giodot.fill = Color.Gray
      }
      else if(newfelhp == 0){
        felsquare.fill = Color.Gray
      }
      else if(newmayhp == 0){
        maysquare.fill == 0
      }
    })}

  def takeTurn(player: String): Unit = {
    if(player == "Ele"){
      eledot.fill = Color.Yellow
    }
    else if(player == "Gio"){
      giodot.fill = Color.Yellow
    }}


  def animate(player: String, target: String, dHP: Int): Unit ={
      takeTurn(player)
      if(target == "Fel"){
        if(dHP > 0){
          newfelhp = newfelhp + dHP
          feltext.text = "HP = " + newfelhp
          felsquare.setStroke(Color.Green)
          felsquare.strokeWidth = 10
        }
        else if(dHP <= 0){
          newfelhp = newfelhp + dHP
          if(newfelhp <= 0){
            felsquare.fill = Color.Gray
            newfelhp = math.max(newfelhp, 0)
          }
          feltext.text = "HP = " + newfelhp
          felsquare.setStroke(Color.Red)
          felsquare.strokeWidth = 10
        }}
        if(target == "May"){
          if(dHP > 0){
            newmayhp = newmayhp + dHP
            maytext.text = "HP = " + newmayhp
            maysquare.setStroke(Color.Green)
            maysquare.strokeWidth = 10
          }
          else if(dHP <= 0){
            newmayhp = newmayhp + dHP
            if(newmayhp <=0){
              maysquare.fill = Color.Gray
              newmayhp = math.max(newmayhp,0)
            }
            maytext.text = "HP = " + newmayhp
            maysquare.setStroke(Color.Red)
            maysquare.strokeWidth = 10
          }
        }
      }





  update(JSstr)

  val eledot: Circle = new Circle{
    centerX = 40.0
    centerY = 40.0
    radius = 15.0
    fill = Color.Blue
  }

  val eletext : TextField = new TextField{
    editable = false
    translateX = 60
    translateY = 20
    maxWidth = 120
    style = "-fx-font: 16 ariel;"

  }

  val eleButton: Button = new Button{
    translateX = 60
    translateY = 20
    style = "-fx-font: 16 ariel;"
    text = "Ele"
    onAction = new ButtonListener4("Ele")
  }

  val giodot: Circle = new Circle{
    centerX = 40.0
    centerY = 80.0
    radius = 15.0
    fill = Color.Blue
  }
  val gioButton: Button = new Button{
    translateX = 60
    translateY = 60
    style = "-fx-font: 16 ariel;"
    text = "Gio"
    onAction = new ButtonListener4("Gio")
  }

  val giotext : TextField = new TextField{
    editable = false
    translateX = 60
    translateY = 60
    maxWidth = 120
    style = "-fx-font: 16 ariel;"

  }

  val PhysicalAttack: Button = new Button{
    translateX = 200
    translateY = 20
    minWidth = 100
    minHeight = 20
    style = "-fx-font: 18 ariel;"
    onAction = new  ButtonListener("Battle Option Selection: Physical Attack", -5)
  }

  val MagicAttack: Button = new Button{
    translateX = 200
    translateY = 60
    minWidth = 100
    minHeight = 20
    style = "-fx-font: 18 ariel;"
    onAction = new  ButtonListener("Battle Option Selection: Magic Attack", -2)

  }

  val Spell: Button = new Button{
    translateX = 200
    translateY = 100
    minWidth = 100
    minHeight = 20
    style = "-fx-font: 18 ariel;"
    onAction = new  ButtonListener("Battle Option Selection: Spell", -3)

  }

  val Heal: Button = new Button{
    translateX = 200
    translateY = 140
    minWidth = 100
    minHeight = 20
    style = "-fx-font: 18 ariel;"
    onAction = new  ButtonListener("Battle Option Selection: Heal", 4)

  }



  val felsquare: Rectangle = new Rectangle {
    width = 30.0
    height = 30.0
    translateX = 460.0
    translateY = 20.0
    fill = Color.Blue
  }

  val feltext: TextField = new TextField{
    translateX = 510
    translateY = 20
    maxWidth = 80
    minHeight = 20
    editable = false
    style = "-fx-font: 16 ariel;"

  }

  val maysquare: Rectangle = new Rectangle {
    width = 30.0
    height = 30.0
    translateX = 460.0
    translateY = 60.0
    fill = Color.Blue
  }

  val maytext: TextField = new TextField{
    translateX = 510
    translateY = 60
    maxWidth = 80
    minHeight = 20
    editable = false
    style = "-fx-font: 16 ariel;"

  }

  val felButton : Button = new Button{
    translateX = 380
    translateY = 20
    style = "-fx-font: 18 ariel;"
    text = "Fel"
    minWidth = 60
    onAction = new ButtonListener1("Target Selection: Fel", "Fel", felsquare)

  }

  val mayButton: Button = new Button{
    translateX = 380
    translateY = 60
    style = "-fx-font: 18 ariel;"
    text = "May"
    minWidth = 60
    onAction = new ButtonListener1("Target Selection: May", "May", maysquare)

  }

  val animateButton: Button = new Button{
    translateX = 380
    translateY = 100
    style = "-fx-font: 18 ariel;"
    text = "Action!"
    onAction = new ButtonListener2

  }
  val playerButton: Button = new Button{
    translateX = 25
    translateY = 100
    style = "-fx-font: 18 ariel;"
    text = "Player"
    onAction = new ButtonListener3

  }


  this.stage = new PrimaryStage {
    this.title = "Battle GUI"
    scene = new Scene(620, 200) {
//      content = List(eledot, eletext, giodot, giotext, PhysicalAttack, MagicAttack, Spell, Heal, felButton, mayButton, felsquare, maysquare, feltext, maytext)
      content = List(eledot, eleButton, giodot, gioButton, PhysicalAttack, MagicAttack, Spell, Heal, felButton, mayButton, felsquare, maysquare, feltext, maytext, animateButton)
    }
    val update: Long => Unit = ( time: Long) => {
      val dt: Double = (time - lastUpdateTime) / 1000000000.0
      BattleDesktopGUI.lastUpdateTime = time
    AnimationTimer(update).start()
  }}



}


