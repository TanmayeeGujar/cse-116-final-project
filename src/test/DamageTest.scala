package test

import org.scalatest._
import main.Character
import main.Party
import main.Character1
import main.Character2
class DamageTest extends FunSuite {

  test("Character 1 initial stats"){
    val C1: Character = new Character1
    assert(C1.level == 1, "wrong level")
    assert(C1.attack_power == 6, "MP wrong")
    assert(C1.magic_attack == 12, "HP wrong")
//    assert(C1.magic_defense == 6, "wrong power")
//    assert(C1.attack_power == 6, "wrong power")
//    assert(C1.attack_power == 6, "wrong power")
  }
  test("Character 2 initial stats"){
    val C1: Character = new Character2
    assert(C1.level == 3, "wrong level")
    assert(C1.attack_power == 10, "MP wrong")
    assert(C1.magic_attack == 0, "HP wrong")
    //    assert(C1.magic_defense == 6, "wrong power")
    //    assert(C1.attack_power == 6, "wrong power")
    //    assert(C1.attack_power == 6, "wrong power")
  }
  test("Character 1 initial battleOptions"){
    val C1: Character = new Character1
    C1.battleOptions()
//    assert(C1.level == 1, "wrong level")
//    assert(C1.currentMP == 20, "MP wrong")
    assert(C1.BattleOptions == List("Physical Attack", "Magic Attack"), "wrong BO")
    //    assert(C1.magic_defense == 6, "wrong power")
    //    assert(C1.attack_power == 6, "wrong power")
    //    assert(C1.attack_power == 6, "wrong power")
  }
  test("Character 2 initial battleOptions"){
    val C1: Character = new Character2
    C1.battleOptions()
//    assert(C1.level == 1, "wrong level")
//    assert(C1.currentMP == 20, "MP wrong")
    assert(C1.BattleOptions == List("Physical Attack", "Magic Attack", "Spell"), "wrong bO")
    //    assert(C1.magic_defense == 6, "wrong power")
    //    assert(C1.attack_power == 6, "wrong power")
    //    assert(C1.attack_power == 6, "wrong power")
  }
  test("Character 1 battleOptions"){
    val C1: Character = new Character1
    C1.battleOptions()
    C1.level = 3
    //    assert(C1.level == 1, "wrong level")
    //    assert(C1.currentMP == 20, "MP wrong")
    assert(C1.BattleOptions == List("Physical Attack", "Magic Attack"), "wrong BO")
    //    assert(C1.magic_defense == 6, "wrong power")
    //    assert(C1.attack_power == 6, "wrong power")
    //    assert(C1.attack_power == 6, "wrong power")
  }
  test("Character 2  battleOptions"){
    val C1: Character = new Character2
    C1.level = 3
    C1.battleOptions()
    //    assert(C1.level == 1, "wrong level")
    //    assert(C1.currentMP == 20, "MP wrong")
    assert(C1.BattleOptions == List("Physical Attack", "Magic Attack", "Spell"), "wrong bO")
    //    assert(C1.magic_defense == 6, "wrong power")
    //    assert(C1.attack_power == 6, "wrong power")
    //    assert(C1.attack_power == 6, "wrong power")
  }
  test("Character 1 stats"){
    val C1: Character = new Character1
    val C2: Character = new Character2
    C1.gainExperience(C2)
    C1.battleOptions()
    C1.level = 3
        assert(C1.attack_power == 6, "wrong level")
        assert(C1.magic_attack == 12, "MP wrong")
//    assert(C1.BattleOptions == List("Physical Attack", "Magic Attack"), "wrong BO")
    //    assert(C1.magic_defense == 6, "wrong power")
    //    assert(C1.attack_power == 6, "wrong power")
    //    assert(C1.attack_power == 6, "wrong power")
  }
  test("Character 2  stats"){
    val C1: Character = new Character2
    val C2: Character = new Character2
    C1.level = 3
    C1.gainExperience(C2)
    C1.battleOptions()
        assert(C1.attack_power == 14, "wrong level")
        assert(C1.magic_attack == 4, "MP wrong")
//    assert(C1.BattleOptions == List("Physical Attack", "Magic Attack", "Spell"), "wrong bO")
    //    assert(C1.magic_defense == 6, "wrong power")
    //    assert(C1.attack_power == 6, "wrong power")
    //    assert(C1.attack_power == 6, "wrong power")
  }
}






