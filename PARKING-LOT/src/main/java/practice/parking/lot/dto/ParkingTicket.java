/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package practice.parking.lot.dto;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;
import practice.parking.lot.dto.parkingspot.ParkingSpot;
import practice.parking.lot.dto.vehicle.Vehicle;

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
