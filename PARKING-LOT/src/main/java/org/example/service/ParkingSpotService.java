/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package org.example.service;

import java.lang.reflect.InvocationTargetException;
import org.example.dto.parkingspot.ParkingSpot;
import org.example.enums.ParkingSpotEnum;

public interface ParkingSpotService {

    ParkingSpot create(ParkingSpotEnum parkingSpotEnum, int floorNum)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;

}
