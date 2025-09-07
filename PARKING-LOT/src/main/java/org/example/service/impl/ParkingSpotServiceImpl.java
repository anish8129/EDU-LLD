/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package org.example.service.impl;

import java.lang.reflect.InvocationTargetException;
import org.example.dto.parkingspot.ParkingSpot;
import org.example.dto.ParkingLot;
import org.example.enums.ParkingSpotEnum;
import org.example.service.DisplayService;
import org.example.service.ParkingSpotService;

public class ParkingSpotServiceImpl implements ParkingSpotService {
    private DisplayService displayService;

    public ParkingSpotServiceImpl() {
        this.displayService = new DisplayServiceImpl();
    }

    @Override
    public ParkingSpot create(ParkingSpotEnum parkingSpotEnum, int floorNum)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        ParkingSpot parkingSpot = (ParkingSpot) parkingSpotEnum.getParkingSpot().getConstructor(Integer.class)
                .newInstance(floorNum);
        ParkingLot.getInstance().getFreeParkingSpots().get(parkingSpotEnum).add(parkingSpot);
        displayService.update(parkingSpotEnum, 1);
        return parkingSpot;
    }
}
