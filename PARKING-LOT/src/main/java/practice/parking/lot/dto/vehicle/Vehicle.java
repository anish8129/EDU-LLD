/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package practice.parking.lot.dto.vehicle;

import java.util.concurrent.atomic.AtomicInteger;
import practice.parking.lot.enums.ParkingSpotEnum;

public abstract class Vehicle {
    private static final AtomicInteger uniqueId = new AtomicInteger(0);
    int id;
    ParkingSpotEnum supportedParkingSpot;

    public Vehicle(ParkingSpotEnum supportedParkingSpot) {
        this.supportedParkingSpot = supportedParkingSpot;
        this.id = uniqueId.incrementAndGet();
    }

    public ParkingSpotEnum getSupportedParkingSpot() {
        return supportedParkingSpot;
    }
}
