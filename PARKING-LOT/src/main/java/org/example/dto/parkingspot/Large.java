/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package org.example.dto.parkingspot;

public class Large extends ParkingSpot {

    public Large(int floorNum, int amount) {
        super(floorNum, amount);
    }

    @Override
    public int cost(int hours) {
        return hours * amount;
    }
}
