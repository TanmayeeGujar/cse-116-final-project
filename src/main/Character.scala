package main

class Character {
  var attack_power: Int = 5
  var defense: Int = 0
  var magic_attack: Int = 5
  var magic_defense: Int = 0
  var maxHP: Int = 10
  var currentHP :Int = maxHP
  var maxMP: Int = 10
  var currentMP: Int = maxMP

  def takeDamage(x:Int): Boolean ={
//    var alive: Boolean  = true
    currentHP = currentHP - x
    if(currentHP <= 0){
       false
    }
    else{ true}
  }
  def dealPhysicalAttack(C1: Character): Boolean ={
    val damageThatGotPast = this.attack_power - C1.defense
    C1.takeDamage(damageThatGotPast)

  }
  def takeMagicDamage(x: Int): Boolean = {
    currentMP = currentMP - x
    if(currentMP <= 0){
      false
    }
    else{true}
  }
  def dealMagicAttack(C2: Character)={
    val damageMA = this.magic_attack - C2.magic_defense
    this.currentMP = this.currentMP - 5
    if(this.currentMP > 0){
      C2.takeMagicDamage(damageMA)
    }
    else if(this.currentMP <=0){
      C2.takeMagicDamage(0)
    }
  }



}
