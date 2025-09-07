/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package org.example.dto;

import org.example.enums.ParkingEventType;
import org.example.enums.ParkingSpotEnum;

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
