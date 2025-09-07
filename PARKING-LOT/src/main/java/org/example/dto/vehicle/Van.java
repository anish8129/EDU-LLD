package org.example.dto.vehicle;

import org.example.enums.ParkingSpotEnum;

public class Van extends Vehicle {

    public Van() {
        super(ParkingSpotEnum.COMPACT);
    }
}