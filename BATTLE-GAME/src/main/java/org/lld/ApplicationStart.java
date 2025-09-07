package org.lld;

import org.lld.service.BattleShipGameService;
import org.lld.service.GameLoop;
import org.lld.stratergy.chance.RoundRobinPlayer;
import org.lld.stratergy.input.RandomInput;

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
