package test

import org.scalatest._
import main.Character
class DamageTest extends FunSuite {

  test("testTakeDamage") {
    var C1: Character = new Character
    assert(C1.takeDamage(5) == true, "not dead")
    assert(C1.takeDamage(5).currentHP == 5, "incorrect decrement")
    assert(C1.takeDamage(11) == false, "dead")
  }
  test("testAttack"){
    var C2: Character = new Character
    var C3: Character = new Character
    assert(C2.dealPhysicalAttack(C3))
  }
}