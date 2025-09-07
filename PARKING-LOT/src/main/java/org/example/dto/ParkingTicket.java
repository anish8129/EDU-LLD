/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package org.example.dto;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;
import org.example.dto.vehicle.Vehicle;
import org.example.dto.parkingspot.ParkingSpot;

public class ParkingTicket {
    private static final AtomicInteger uniqueId = new AtomicInteger(0);
    int id;
    Vehicle vehicle;
    ParkingSpot parkingSpot;
    LocalDateTime timeStamp;

    public ParkingTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.id = uniqueId.incrementAndGet();
        this.timeStamp = LocalDateTime.now();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public int getParkingHours() {
        return 2;
    }
}
