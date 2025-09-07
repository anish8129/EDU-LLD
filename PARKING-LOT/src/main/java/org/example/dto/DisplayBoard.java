/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package org.example.dto;

import java.util.HashMap;
import java.util.Map;
import org.example.enums.ParkingSpotEnum;

public class DisplayBoard {
    private static DisplayBoard displayBoard = null;
    Map<ParkingSpotEnum, Integer> freeParkingSpotsByType;

    private DisplayBoard() {
        this.freeParkingSpotsByType = new HashMap<>();
    }

    public static DisplayBoard getInstance() {
        if (displayBoard == null) {
            displayBoard = new DisplayBoard();
        }
        return displayBoard;
    }

    public Map<ParkingSpotEnum, Integer> getFreeParkingSpotsByType() {
        return freeParkingSpotsByType;
    }
}
