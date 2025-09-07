/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package org.example;

import java.lang.reflect.InvocationTargetException;
import org.example.service.ParkingSpotService;
import org.example.service.impl.ParkingSpotServiceImpl;
import org.example.dto.ParkingLot;
import org.example.dto.parkingspot.ParkingSpot;
import org.example.dto.parkingspot.spot.decorator.Electric;
import org.example.dto.parkingspot.spot.decorator.Wash;
import org.example.enums.ParkingSpotEnum;

public class Main {

    public static void main(String[] args)
            throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ParkingLot parkingLot = ParkingLot.getInstance();
        ParkingSpotService parkingSpotService = new ParkingSpotServiceImpl();
        ParkingSpot parkingSpot = parkingSpotService.create(ParkingSpotEnum.COMPACT, 0);
        Electric electric = new Electric(parkingSpot);
        Wash wash = new Wash(electric);


    }

}
