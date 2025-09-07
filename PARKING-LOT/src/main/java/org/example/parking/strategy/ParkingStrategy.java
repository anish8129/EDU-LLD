/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package org.example.parking.strategy;

import org.example.enums.ParkingSpotEnum;
import org.example.exceptions.SpotNotFound;
import org.example.dto.parkingspot.ParkingSpot;

public interface ParkingStrategy {

    ParkingSpot findParkingSpot(ParkingSpotEnum parkingSpotEnum) throws SpotNotFound;

}
