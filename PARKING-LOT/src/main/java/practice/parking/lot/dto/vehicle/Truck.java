package practice.parking.lot.dto.vehicle;

import practice.parking.lot.enums.ParkingSpotEnum;

public class Truck extends Vehicle {

    public Truck() {
        super(ParkingSpotEnum.LARGE);
    }
}