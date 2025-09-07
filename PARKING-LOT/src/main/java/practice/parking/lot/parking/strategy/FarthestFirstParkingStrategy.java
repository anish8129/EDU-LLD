/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package practice.parking.lot.parking.strategy;


import java.util.List;
import practice.parking.lot.dto.ParkingLot;
import practice.parking.lot.dto.parkingspot.ParkingSpot;
import practice.parking.lot.enums.ParkingSpotEnum;
import practice.parking.lot.exceptions.SpotNotFound;

public class FarthestFirstParkingStrategy implements ParkingStrategy {

    @Override
    public ParkingSpot findParkingSpot(ParkingSpotEnum parkingSpotEnum) throws SpotNotFound {
        List<ParkingSpot> parkingSpots = ParkingLot.getInstance().getFreeParkingSpots().get(parkingSpotEnum);
        if (parkingSpots.size() == 0) {
            throw new SpotNotFound("Spot Not Found");
        }
        return parkingSpots.get(parkingSpots.size() -1);
    }
}
