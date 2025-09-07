/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package practice.parking.lot.service;

import practice.parking.lot.dto.ParkingEvent;

public interface Observer {

    void update(ParkingEvent event);

}
