package org.example;

import org.example.service.BattleShipGameService;
import org.example.service.GameLoop;
import org.example.stratergy.chance.RoundRobinPlayer;
import org.example.stratergy.input.RandomInput;

/**
 * Hello world!
 */

public class ApplicationStart {

    public static void main(String[] args) {
        BattleShipGameService battleShipGameService = new BattleShipGameService(10, new RoundRobinPlayer());
        battleShipGameService.viewBattleGround();
        GameLoop gameLoop = new GameLoop(new RandomInput(), battleShipGameService);
        gameLoop.startGame();
    }
}
