/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package practice.parking.lot.enums;
import practice.parking.lot.dto.parkingspot.Compact;
import practice.parking.lot.dto.parkingspot.Large;
import practice.parking.lot.dto.parkingspot.Mini;
import practice.parking.lot.dto.parkingspot.ParkingSpot;

public enum ParkingSpotEnum {

    LARGE(Large.class, new Large()),
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
