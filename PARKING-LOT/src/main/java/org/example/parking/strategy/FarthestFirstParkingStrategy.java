/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package org.example.parking.strategy;


import java.util.List;
import org.example.dto.ParkingLot;
import org.example.enums.ParkingSpotEnum;
import org.example.exceptions.SpotNotFound;
import org.example.dto.parkingspot.ParkingSpot;

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
