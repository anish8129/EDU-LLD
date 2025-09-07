/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package org.car.rental.dto;

import java.util.Date;
import java.util.List;
import org.car.rental.dto.assistnace.Assistance;
import org.car.rental.dto.equipment.Equipment;
import org.car.rental.dto.user.Customer;
import org.car.rental.dto.vehicle.Vehicle;
import org.car.rental.enums.ResStatus;

public class Reservation {
    int reservationId;
    Date reservationDate;
    Customer customer;
    Vehicle vehicle;
    Date startDate;
    Date endDate;
    ResStatus resStatus;
    List<Equipment> equipments;
    List<Assistance> assistance;

    public double calculateCost() {
        double eSum = equipments.stream().mapToDouble(Equipment::getCost).sum();
        double assistSum = assistance.stream().mapToDouble(Assistance::getCost).sum();
        vehicle.getRentalCost();
        return vehicle.getRentalCost() + eSum + assistSum;
    }
}
