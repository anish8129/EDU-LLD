/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package org.lld.stratergy.chance;

import java.util.List;
import org.lld.model.Player;

public interface PlayerChanceStratergy {

    Player nextPlayer(List<Player> playerList);

}
