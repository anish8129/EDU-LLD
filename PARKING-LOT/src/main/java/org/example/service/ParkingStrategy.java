/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package org.example.service;

import org.example.dto.parkingspot.ParkingSpot;
import org.example.enums.ParkingSpotEnum;

public interface ParkingStrategy {

    ParkingSpot findParkingSpot(ParkingSpotEnum parkingSpotEnum);

}
