/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package org.car.rental.dto.vehicle;

import java.util.Date;
import org.car.rental.enums.Features;
import org.car.rental.enums.VehicleStatusEnum;
import org.car.rental.enums.VanTypeEnum;

public abstract class Vehicle {
    int vehicleNo;
    Date dateOfRegistration;
    VanTypeEnum vehicleType;
    VehicleStatusEnum vehicleStatus;
    boolean isFree;
    String model;
    Features features;

    public Vehicle(int vehicleNo, Date dateOfRegistration, VanTypeEnum vehicleType,
            boolean isFree,
            String model, Features features) {
        this.vehicleNo = vehicleNo;
        this.dateOfRegistration = dateOfRegistration;
        this.vehicleType = vehicleType;
        this.isFree = isFree;
        this.model = model;
        this.features = features;
    }

    public abstract double getRentalCost();
}
