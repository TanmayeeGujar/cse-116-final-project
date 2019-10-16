package main

class Character1 extends Character {
  attack_power = 6
  defense = 6
  magic_attack = 12
  magic_defense = 6
  maxHP = 10
  currentHP = maxHP
  maxMP = 20
  currentMP = maxMP
  experience = 10
  level = 1
  DOA = true
  BattleOptions = List()

  override def takeDamage(x: Int): Boolean = {
    currentHP = currentHP - x
    if(currentHP <= 0){
      currentHP = 0
      DOA = false
      false
  }
    else{ DOA = true
      true}}

  override def dealPhysicalAttack(C1: Character): Unit = {
    val damageThatGotPast = this.attack_power - C1.defense
    C1.takeDamage(damageThatGotPast)
    if(C1.currentHP <=0){
      this.gainExperience(C1)
    }

  }

  override def takeMagicDamage(x: Int): Unit = {
    currentMP = currentMP - x
    if(currentMP <= 0){
      currentMP = 0
//      DOA = false
//      false
    }
//    else{DOA = true
//      true}
  }

  override def dealMagicAttack(C2: Character): AnyVal = {
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

  override def gainExperience(C3: Character): Unit = {
    var n = (this.experience/20).floor.toInt
    //    val physicalDamageThatGotPast = this.attack_power - C3.defense
    //    val magicDamageThatGotPast = this.magic_attack - C3.magic_defense
    //    if(C3.takeDamage(physicalDamageThatGotPast)==false || C3.takeMagicDamage(magicDamageThatGotPast)==false){
    this.experience = this.experience+(2*C3.maxMP)
    //    }
    if(this.experience>=20){
//      var n = (this.experience/20).floor.toInt
      this.level = 1+n
      //      this.experience = this.experience-(20*n)
      for(i <- 1 to n){
        this.attack_power = this.attack_power+6
        this.defense = this.defense+4
        this.magic_attack = this.magic_attack+6
        this.magic_defense = this.magic_defense+4
        this.maxHP = this.maxHP+5
        this.maxMP = this.maxMP+5
      }

    }

  }

  override def heal(C1: Character) : Unit = {
    C1.currentHP = C1.currentHP + 3
    C1.currentMP = C1.currentMP + 1
  }

  override def castSpell(C1: Character) : Unit = {
    var SpellCount : Int = 0
    while (SpellCount < 3) {
      C1.magic_attack = C1.magic_attack -2
      SpellCount = SpellCount + 1
    }
  }



  override def battleOptions() ={
    var battle1 : String = "Physical Attack"
    var battle2 : String = "Magic Attack"
    var battle3 : String = "Spell"
    var battle4 : String = "Heal"
    if(this.level <=2){
      BattleOptions = List(battle1, battle2)}

    else if(this.level >2 && this.level <4){
      BattleOptions = List(battle1, battle2, battle3)}
    else if(this.level >=4 && this.level <5){
      BattleOptions = List(battle1, battle2, battle3, battle4)}
    BattleOptions
  }

  override def takeAction(battle: String, C1: Character) = {
    var actionList = this.battleOptions()
    if(battle == actionList(0)){
      this.dealPhysicalAttack(C1)
    }
    if(battle == actionList(1)){
      this.dealMagicAttack(C1)
    }
    if(battle == actionList(2)){
      this.castSpell(C1)
    }
    if(battle == actionList(3)){
      this.heal(C1)
    }
    if(!actionList.contains(battle)){

    }
  }

}
