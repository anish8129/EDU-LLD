/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package org.example.service.impl;


import org.example.dto.DisplayBoard;
import org.example.dto.ParkingEvent;
import org.example.enums.ParkingEventType;
import org.example.enums.ParkingSpotEnum;
import org.example.service.DisplayService;
import org.example.service.Observer;

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
