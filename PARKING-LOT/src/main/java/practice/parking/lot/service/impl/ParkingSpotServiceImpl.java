/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package practice.parking.lot.service.impl;

import java.lang.reflect.InvocationTargetException;
import practice.parking.lot.dto.parkingspot.ParkingSpot;
import practice.parking.lot.dto.ParkingLot;
import practice.parking.lot.enums.ParkingSpotEnum;
import practice.parking.lot.service.DisplayService;
import practice.parking.lot.service.ParkingSpotService;

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
