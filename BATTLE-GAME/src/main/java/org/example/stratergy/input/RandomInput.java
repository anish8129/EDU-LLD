/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package org.example.stratergy.input;

import org.example.model.CoOrdinate;
import org.example.model.Player;

public class RandomInput implements InputStratergy {

    @Override
    public CoOrdinate takeInput(Player player) {
        int x = getRandomNumber(player.getStart().getX(), player.getEnd().getX());
        int y = getRandomNumber(player.getStart().getY(), player.getEnd().getY());
        return new CoOrdinate(x, y);
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
