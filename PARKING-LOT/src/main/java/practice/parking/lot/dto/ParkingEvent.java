/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package practice.parking.lot.dto;

import practice.parking.lot.enums.ParkingEventType;
import practice.parking.lot.enums.ParkingSpotEnum;

public class ParkingEvent {
    private ParkingEventType parkingEventType;
    private ParkingSpotEnum parkingSpotEnum;

    public ParkingEvent(ParkingEventType parkingEventType, ParkingSpotEnum parkingSpotEnum) {
        this.parkingEventType = parkingEventType;
        this.parkingSpotEnum = parkingSpotEnum;
    }

    public ParkingEventType getParkingEventType() {
        return parkingEventType;
    }

    public ParkingSpotEnum getParkingSpotEnum() {
        return parkingSpotEnum;
    }
}
