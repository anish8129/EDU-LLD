package practice.parking.lot.dto.parkingspot;

import practice.parking.lot.dto.parkingspot.ParkingSpot;

public class Compact extends ParkingSpot {

    public Compact(int floorNum, int amount) {
        super(floorNum, amount);
    }

    @Override
    public int cost(int hours) {
        return hours * amount;
    }
}