/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package practice.parking.lot;

import java.lang.reflect.InvocationTargetException;
import practice.parking.lot.dto.ParkingLot;
import practice.parking.lot.dto.parkingspot.ParkingSpot;
import practice.parking.lot.dto.parkingspot.spot.decorator.Electric;
import practice.parking.lot.dto.parkingspot.spot.decorator.Wash;
import practice.parking.lot.enums.ParkingSpotEnum;
import practice.parking.lot.service.ParkingSpotService;
import practice.parking.lot.service.impl.ParkingSpotServiceImpl;

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
