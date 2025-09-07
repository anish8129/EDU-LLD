/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package practice.parking.lot.service;

import practice.parking.lot.dto.ParkingTicket;
import practice.parking.lot.dto.vehicle.Vehicle;

public interface ParkingLotService {

    ParkingTicket entry(Vehicle vehicle);

    int exit(ParkingTicket parkingTicket, Vehicle vehicle);

}
