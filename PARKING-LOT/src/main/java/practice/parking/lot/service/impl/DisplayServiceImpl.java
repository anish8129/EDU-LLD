/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package practice.parking.lot.service.impl;


import practice.parking.lot.dto.DisplayBoard;
import practice.parking.lot.dto.ParkingEvent;
import practice.parking.lot.enums.ParkingEventType;
import practice.parking.lot.enums.ParkingSpotEnum;
import practice.parking.lot.service.DisplayService;
import practice.parking.lot.service.Observer;

public class DisplayServiceImpl implements DisplayService, Observer {

    @Override
    public void update(ParkingSpotEnum parkingSpotEnum, int change) {
        int currentCount = DisplayBoard.getInstance().getFreeParkingSpotsByType().get(parkingSpotEnum);
        int newCount = currentCount + change;
        DisplayBoard.getInstance().getFreeParkingSpotsByType().replace(parkingSpotEnum, newCount);
    }

    @Override
    public void update(ParkingEvent event) {
        if (event.getParkingEventType() == ParkingEventType.ENTRY) {
            update(event.getParkingSpotEnum(), -1);
        } else if (event.getParkingEventType() == ParkingEventType.EXIT) {
            update(event.getParkingSpotEnum(), 1);
        }
    }
}
