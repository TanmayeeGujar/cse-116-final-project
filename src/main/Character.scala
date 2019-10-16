package main

abstract class Character {
  var attack_power: Int = 8
  var defense: Int = 2
  var magic_attack: Int = 8
  var magic_defense: Int = 2
  var maxHP: Int = 10
  var currentHP :Int = maxHP
  var maxMP: Int = 10
  var currentMP: Int = maxMP
  var experience: Int = 0
  var level:Int = 1
  var DOA: Boolean = true
  var BattleOptions: List[String] = List()

  def takeDamage(x:Int): Boolean ={
//    var alive: Boolean  = true
    currentHP = currentHP - x
    if(currentHP <= 0){
      currentHP = 0
      DOA = false
      false
    }
    else{ DOA = true
    true}
  }
  def dealPhysicalAttack(C1: Character) ={
    val damageThatGotPast = this.attack_power - C1.defense
    C1.takeDamage(damageThatGotPast)
    if(C1.currentHP <=0){
      this.gainExperience(C1)
    }

  }
  def takeMagicDamage(x: Int): Unit = {
    currentMP = currentMP - x
//    if(currentMP <= 0){
//      currentMP = 0
//      DOA = false
//      false
//    }
//    else{DOA = true
//    true}
  }
  def dealMagicAttack(C2: Character): AnyVal={
    val damageMA = this.magic_attack - C2.magic_defense
    this.currentMP = this.currentMP - 5
    if(this.currentMP > 0){
      C2.takeMagicDamage(damageMA)
      if(C2.currentMP <= 0){
      this.gainExperience(C2)}
    }
    else if(this.currentMP <=0){
      C2.takeMagicDamage(0)
    }
  }
  def gainExperience(C3: Character): Unit = {
//    val physicalDamageThatGotPast = this.attack_power - C3.defense
//    val magicDamageThatGotPast = this.magic_attack - C3.magic_defense
//    if(C3.takeDamage(physicalDamageThatGotPast)==false || C3.takeMagicDamage(magicDamageThatGotPast)==false){
      this.experience = this.experience+(2*C3.maxMP)
//    }
    if(this.experience>=20){
      var n = (this.experience/20).floor.toInt
      this.level = 1+n
//      this.experience = this.experience-(20*n)
      for(i <- 1 to n){
        this.attack_power = this.attack_power+4
        this.defense = this.defense+2
        this.magic_attack = this.magic_attack+4
        this.magic_defense = this.magic_defense+2
        this.maxHP = this.maxHP+5
        this.maxMP = this.maxMP+5
      }

    }
  }

  def heal(C1: Character) : Unit = {
    C1.currentHP = C1.maxHP
//    this.currentMP = this.currentMP + 2
  }

  def castSpell(C1: Character) : Unit = {
//    var SpellCount = 0
//    while(SpellCount !=2) {
      C1.magic_attack = (C1.magic_attack /2).ceil.toInt
//      SpellCount = SpellCount +1
//
//    }
  }

  def battleOptions() = {
//    var battle1 : String = "Physical Attack"
//    var battle2 : String = "Magic Attack"
//    var battle3 : String = "Spell"
//    var battle4 : String = "Heal"
//    if(this.level < 3){
//      BattleOptions = List(battle1, battle2)}
//
//    else if(this.level >=2 && this.level <4){
//      BattleOptions = List(battle1, battle2, battle3)}
//    else if(this.level >=4 && this.level <5){
//      BattleOptions = List(battle1, battle2, battle3, battle4)}
    BattleOptions
  }

  def takeAction(battle: String, C1: Character) = {
//    var actionList = battleOptions()
//    if(battle == actionList(0)){
//      this.dealPhysicalAttack(C1)
//    }
//    if(battle == actionList(1)){
//      this.dealMagicAttack(C1)
//    }
//    if(!actionList.contains(battle)){
//      null
//    }
  }




}
