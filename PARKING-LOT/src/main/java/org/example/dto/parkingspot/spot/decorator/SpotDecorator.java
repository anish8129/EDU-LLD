/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package org.example.dto.parkingspot.spot.decorator;

import org.example.dto.parkingspot.ParkingSpot;

public abstract class SpotDecorator extends ParkingSpot {
    protected ParkingSpot parkingSpot;

    public SpotDecorator(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
}
