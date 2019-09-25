package main

class Party(var teamParty: List[Character]){
//  var teamParty: List[Character]
//  var expCounter: Int = 0
var aliveWinnerChars:Int = 0
  var eachCharExpIncrease : Int = 0
  def gainPartyExp(defeatedParty: Party) ={
    var expCounter: Int = 0
    for (i <- defeatedParty.teamParty){
      expCounter = expCounter + i.experience
    }
//    var thisPartyCharacters: Int = this.teamParty.length
//    var aliveWinnerChars:Int = 0
//    var eachCharExpIncrease: Int = expCounter/thisPartyCharacters
    for (j <- this.teamParty){
      if(j.DOA == true){
        aliveWinnerChars = aliveWinnerChars + 1
      }}
    eachCharExpIncrease = (expCounter/aliveWinnerChars).floor.toInt


    for (k <- this.teamParty){
      if(k.DOA == true){



//      var eachCharExpIncrease = expCounter/aliveWinnerChars
      k.experience = k.experience + eachCharExpIncrease}

    }
  }

}
