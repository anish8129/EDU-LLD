/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package org.example.service;

import org.example.dto.vehicle.Vehicle;
import org.example.dto.ParkingTicket;

public interface ParkingLotService {

    ParkingTicket entry(Vehicle vehicle);

    int exit(ParkingTicket parkingTicket, Vehicle vehicle);

}
