socket.on('turnReady', function (event) {
    turnReady(event);
});

let turnState = "none"; // "chooseOption" "chooseTarget"
let turnQueue = [];
let chosenOption = "";

let currentBattleOptions = [];
let currentTurnName = "";
let filteredParties = [];

function turnReady(event) {
    if (turnQueue.length === 0 && turnState === "none") {
        takeTurn(event);
    } else {
        turnQueue.push(event)
    }
}

function takeTurn(characterName) {
    currentTurnName = characterName;
    let i = 0;
    for (let friend of initialBattleState['playerParty']['characters']) {
        if (friend['name'] === characterName) {
            currentBattleOptions = friend['battleOptions'];
            drawCharacter(1, i, "white", friend);
            drawOptions(currentBattleOptions);
            turnState = "chooseOption"
        }
        i++;
    }
}
