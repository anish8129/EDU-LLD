/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package org.example.dto.parkingspot.spot.decorator;

import org.example.dto.parkingspot.ParkingSpot;

public class Wash extends SpotDecorator {

    public Wash(ParkingSpot parkingSpot) {
        super(parkingSpot);
    }

    @Override
    public int cost(int hours) {
        return parkingSpot.cost(hours) + 50;
    }
}
