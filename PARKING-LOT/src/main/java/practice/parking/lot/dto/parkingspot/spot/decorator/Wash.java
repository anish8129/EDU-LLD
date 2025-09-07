/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package practice.parking.lot.dto.parkingspot.spot.decorator;

import practice.parking.lot.dto.parkingspot.ParkingSpot;

public class Wash extends SpotDecorator {

    public Wash(ParkingSpot parkingSpot) {
        super(parkingSpot);
    }

    @Override
    public int cost(int hours) {
        return parkingSpot.cost(hours) + 50;
    }
}
