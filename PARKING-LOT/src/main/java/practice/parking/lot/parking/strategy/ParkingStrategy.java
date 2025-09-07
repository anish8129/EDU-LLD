/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package practice.parking.lot.parking.strategy;

import practice.parking.lot.dto.parkingspot.ParkingSpot;
import practice.parking.lot.enums.ParkingSpotEnum;
import practice.parking.lot.exceptions.SpotNotFound;

public interface ParkingStrategy {

    ParkingSpot findParkingSpot(ParkingSpotEnum parkingSpotEnum) throws SpotNotFound;

}
