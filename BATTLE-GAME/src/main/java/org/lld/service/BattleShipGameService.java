/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package org.lld.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.lld.model.BattleItem;
import org.lld.model.Ship;
import org.lld.stratergy.chance.PlayerChanceStratergy;
import org.lld.model.CoOrdinate;
import org.lld.model.Player;

public class BattleShipGameService {

    private int N;
    private List<Player> playerList = new ArrayList<>();
    private PlayerChanceStratergy playerChanceStratergy;

    private Set<CoOrdinate> firedMissiles = new HashSet<>();


    public BattleShipGameService(int size, PlayerChanceStratergy playerChanceStratergy) {
        this.N = size;
        this.playerChanceStratergy = playerChanceStratergy;
        Player p1 = new Player(1, new CoOrdinate(0, 0), new CoOrdinate(N/2 - 1, N-1));
        Player p2 = new Player(2, new CoOrdinate(N/2 - 1, N/2 - 1), new CoOrdinate(N-1, N-1));
        playerList.add(p1);
        playerList.add(p2);
        addBattleItem(p1, new Ship("SH1", 2, 1, 1));
        addBattleItem(p2, new Ship("SH1", 2, 7, 1));
        addBattleItem(p1, new Ship("SH2", 2, 2, 5));
        addBattleItem(p2, new Ship("SH2", 2, 6, 7));
        addBattleItem(p1, new Ship("SH3", 2, 2, 8));
        addBattleItem(p2, new Ship("SH3", 2, 8, 8));
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void viewBattleGround() {
        String grid[][] = new String[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = " . ";
            }
        }

        for (Player player: playerList) {
            for (BattleItem item : player.getBattleItems()) {
                for (int i = item.start().getX() ; i <= item.end().getX(); i++) {
                    for (int j = item.start().getY() ; j <= item.end().getY(); j++) {
                        grid[i][j] = String.format("%s%s ",player.getId(),player.getId());
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    public boolean canTakeHit(CoOrdinate coOrdinate) {
        return !firedMissiles.contains(coOrdinate);
    }

    public String hit(Player player, CoOrdinate coOrdinate) {
        firedMissiles.add(coOrdinate);
        for (Player player1 : playerList) {
            if(player1 == player && player1.checkIsInRange(coOrdinate)) {
                return player1.takeHit(coOrdinate);
            }
        }
        return "Invalid Region";
    }

    public Player getNexPlayer() {
        return playerChanceStratergy.nextPlayer(playerList);
    }

    public boolean isGameOver() {
        int count = 0;
        for (Player player: playerList) {
            if (player.isAllBattleItemDestroyed()) {
                count++;
            }
        }

        return count == playerList.size() - 1;
    }

    public String getWinner() {
        for (Player player: playerList) {
            if (!player.isAllBattleItemDestroyed()) {
                return String.format("Player %s is winner", player.getId());
            }
        }
        return "No Winner found";
    }

    public void addBattleItem(Player player, BattleItem item) {
        player.addShip(item);
    }
}
