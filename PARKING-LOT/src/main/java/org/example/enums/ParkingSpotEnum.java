/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package org.example.enums;
import org.example.dto.parkingspot.Compact;
import org.example.dto.parkingspot.Large;
import org.example.dto.parkingspot.Mini;

public enum ParkingSpotEnum {

    LARGE(Large.class),
    COMPACT(Compact.class),
    MINI(Mini.class);

    private final Class parkingSpotClass;

    ParkingSpotEnum(Class parkingSpotClass) {
        this.parkingSpotClass = parkingSpotClass;
    }

    public Class getParkingSpot() {
        return parkingSpotClass;
    }
}
