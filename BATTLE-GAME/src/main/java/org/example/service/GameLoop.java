/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package org.example.service;

import java.util.List;
import org.example.model.CoOrdinate;
import org.example.model.Player;
import org.example.stratergy.input.InputStratergy;

public class GameLoop {

    private final InputStratergy inputStratergy;
    private final BattleShipGameService battleShipGameService;

    public GameLoop(InputStratergy inputStratergy, BattleShipGameService battleShipGameService) {
        this.inputStratergy = inputStratergy;
        this.battleShipGameService = battleShipGameService;
    }

    public void startGame() {
        while(!isGameOver()) {
            Player player = battleShipGameService.getNexPlayer();
            Player opponent = findOpponent(battleShipGameService.getPlayerList(), player);
            CoOrdinate coOrdinate = inputStratergy.takeInput(opponent);
            while (!battleShipGameService.canTakeHit(coOrdinate)) {
                coOrdinate = inputStratergy.takeInput(opponent);
            }
            System.out.println(String.format("Player %s turn hitting %s" , player.getId(), coOrdinate));
            String msg = battleShipGameService.hit(opponent, coOrdinate);
            System.out.println("Player " + player.getId() + " " + msg);
        }
        getWinner();
    }

    private Player findOpponent(List<Player> playerList, Player player) {
        return playerList.stream().filter(val -> val != player).findFirst().get();
    }

    private boolean isGameOver() {
        return battleShipGameService.isGameOver();
    }

    private void getWinner() {
        System.out.println(battleShipGameService.getWinner());
    }

}
