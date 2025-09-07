package org.example.dto.parkingspot;

public class Compact extends ParkingSpot {

    public Compact(int floorNum, int amount) {
        super(floorNum, amount);
    }

    @Override
    public int cost(int hours) {
        return hours * amount;
    }
}