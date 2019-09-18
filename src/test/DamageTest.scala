package test

import org.scalatest._
import main.Character
class DamageTest extends FunSuite {

  test("test decrement") {
    val C1: Character = new Character
    C1.takeDamage(5)
    assert(C1.currentHP == 5, "incorrect decrement")
  }
  test("Character alive"){
    val C2: Character = new Character
    assert(C2.takeDamage(5)== true, "wrongly dead")
  }
  test("Character dead"){
    val C2: Character = new Character
    assert(C2.takeDamage(11)== false, "wrongly alive")
  }
  test("test PhysicalAttack current HP"){
    val C1: Character = new Character
    val C2: Character = new Character
    C1.dealPhysicalAttack(C2)
    assert(C2.currentHP == 5, "wrong decrement")
  }
  test ("test MagicAttack test current MP"){
    val C1: Character = new Character
    val C2: Character = new Character
    C1.dealMagicAttack(C2)
    assert(C2.currentMP == 5, "incorrect decrement for attacked player")
    assert(C1.currentMP == 5, "incorrect decrement for attacker")
  }
  test("attack Without MP"){
    val C1: Character = new Character
    val C2: Character = new Character
    C1.currentMP = 0
    assert(C1.dealMagicAttack(C2) == true, "DOA: incorrect, not enough MP")
  }
}