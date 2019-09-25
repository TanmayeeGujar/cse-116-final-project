package test

import org.scalatest._
import main.Character
import main.Party
class DamageTest extends FunSuite {

  test("test decrement") {
    val C1: Character = new Character
    C1.takeDamage(5)
    assert(C1.currentHP == 5, "incorrect HP decrement")
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
    assert(C2.currentHP == 4, "wrong decrement")
  }
  test ("test MagicAttack test current MP"){
    val C1: Character = new Character
    val C2: Character = new Character
    C1.dealMagicAttack(C2)
    assert(C2.currentMP == 4, "incorrect decrement for attacked player")
    assert(C1.currentMP == 5, "incorrect decrement for attacker")
  }
  test("attack Without MP"){
    val C1: Character = new Character
    val C2: Character = new Character
    C1.currentMP = 0
    assert(C1.dealMagicAttack(C2) == true, "DOA: incorrect, not enough MP")
  }
  test("experience increment") {
    var C1: Character = new Character
    var C2: Character = new Character
    //    C2.currentHP = 4
    C1.dealPhysicalAttack(C2)
    assert(C1.experience == 20, "incorrect experience increment")
  }
  test("insufficient experience for increment"){
    var C1: Character = new Character
    var C2: Character = new Character
    C1.experience = 6
    C1.level = 1
    C2.maxMP = 2
    C1.gainExperience(C2)
    assert(C1.level == 1, "incorrect level increase")

  }
  test("single level increase"){
    val C1: Character = new Character
    val C2: Character = new Character
    C1.dealPhysicalAttack(C2)
    assert(C1.experience == 20, "incorrect experience")
    assert(C1.level == 2, "incorrect level increment")
    assert(C1.maxMP == 15, "incorrect stat upgrade maxMP")
    assert(C1.maxHP == 15, "incorrect stat upgrade maxHP")
    assert(C1.attack_power == 12, "incorrect stat update attack_power")
    assert(C1.defense == 4, "incorrect stat update defense")
    assert(C1.magic_attack == 12, "incorrect stat increase magic_attack")
    assert(C1.magic_defense == 4, "incorrect stat increase magic_defense")
  }
  test("multi level increase"){
    val C1: Character = new Character
    val C2: Character = new Character
    val C3: Character = new Character
    C1.dealPhysicalAttack(C2)
    C1.dealPhysicalAttack(C3)
    assert(C1.level == 3, "incorrect # levels")
  }
  test("party testing DOA"){
    var C1: Character = new Character
    var C2: Character = new Character
    var C3: Character = new Character
    var C4: Character = new Character
    var C5: Character = new Character
    var C6: Character = new Character
    var L1: List[Character] = List(C1, C2, C3)
    var L2: List[Character] = List(C4, C5, C6)
    var P1:Party = new Party(L1)
    var P2:Party = new Party(L2)
//    P1.teamParty.length = 3
    C2.DOA = false
    P1.gainPartyExp(P2)
    assert(P1.aliveWinnerChars == 2, "wrong DOA count")

  }
  test("party experience increment test (if total experience is odd, some winners dead)"){
    var C1: Character = new Character
    var C2: Character = new Character
    var C3: Character = new Character
    var C4: Character = new Character
    var C5: Character = new Character
    var C6: Character = new Character
    var L1: List[Character] = List(C1, C2, C3)
    var L2: List[Character] = List(C4, C5, C6)
    var P1:Party = new Party(L1)
    var P2:Party = new Party(L2)
    C2.DOA = false
    C4.experience = 2
    C5.experience = 5
    C6.experience = 4
    P1.gainPartyExp(P2)
    assert(P1.eachCharExpIncrease == 5, "incorrect calculations")
    assert(C1.experience == 5, "Winner increment wrong C1")
    assert(C2.experience == 0, "dead member gaining experience")
    assert(C3.experience == 5, "Winner increment wrong C3")
  }
  test("party experience increment test (if total experience even, all winners alive)"){
    var C1: Character = new Character
    var C2: Character = new Character
    var C3: Character = new Character
    var C4: Character = new Character
    var C5: Character = new Character
    var C6: Character = new Character
    var C7: Character = new Character
    var C8: Character = new Character
    var L1: List[Character] = List(C1, C2, C3, C4)
    var L2: List[Character] = List(C5, C6, C7, C8)
    var P1:Party = new Party(L1)
    var P2:Party = new Party(L2)
    C5.experience = 2
    C6.experience = 1
    C7.experience = 7
    C8.experience = 6
    P1.gainPartyExp(P2)
    assert(P1.eachCharExpIncrease == 4, "incorrect calculations")
    assert(C1.experience == 4, "Winner increment wrong C1")
    assert(C2.experience == 4, "Winner increment wrong C2")
    assert(C3.experience == 4, "Winner increment wrong C3")
    assert(C4.experience == 4, "Winner increment wrong C4")
  }
}