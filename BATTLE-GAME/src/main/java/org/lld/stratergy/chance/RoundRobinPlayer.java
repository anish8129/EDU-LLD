/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package org.lld.stratergy.chance;

import java.util.List;
import org.lld.model.Player;

public class RoundRobinPlayer implements PlayerChanceStratergy {

    int currentPlayerIndex = -1;

    @Override
    public Player nextPlayer(List<Player> playerList) {
        int nextPlayer = (currentPlayerIndex + 1) % playerList.size();
        currentPlayerIndex = nextPlayer;
        return playerList.get(nextPlayer);
    }
}
