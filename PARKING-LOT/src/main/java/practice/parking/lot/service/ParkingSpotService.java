/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package practice.parking.lot.service;

import java.lang.reflect.InvocationTargetException;
import practice.parking.lot.dto.parkingspot.ParkingSpot;
import practice.parking.lot.enums.ParkingSpotEnum;

public interface ParkingSpotService {

    ParkingSpot create(ParkingSpotEnum parkingSpotEnum, int floorNum)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;

}
