package main

class Character {
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
    this.gainExperience(C1)

  }
  def takeMagicDamage(x: Int): Boolean = {
    currentMP = currentMP - x
    if(currentMP <= 0){
      false
    }
    else{true}
  }
  def dealMagicAttack(C2: Character): AnyVal={
    val damageMA = this.magic_attack - C2.magic_defense
    this.currentMP = this.currentMP - 5
    if(this.currentMP > 0){
      C2.takeMagicDamage(damageMA)
      this.gainExperience(C2)
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




}
