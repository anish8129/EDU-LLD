/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package org.example.dto.vehicle;

import java.util.Date;
import org.example.enums.Features;
import org.example.enums.VehicleStatusEnum;
import org.example.enums.VanTypeEnum;

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
