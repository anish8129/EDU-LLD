package practice.parking.lot.dto.vehicle;

import practice.parking.lot.enums.ParkingSpotEnum;

public class Van extends Vehicle {

    public Van() {
        super(ParkingSpotEnum.COMPACT);
    }
}