/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package org.example.dto.vehicle;

import java.util.Date;
import org.example.enums.Features;
import org.example.enums.VanTypeEnum;

public class Van extends Vehicle {

    public Van(int vehicleNo, Date dateOfRegistration, VanTypeEnum vehicleType,
            boolean isFree, String model, Features features) {
        super(vehicleNo, dateOfRegistration, vehicleType, isFree, model, features);
    }

    @Override
    public double getRentalCost() {
        return 0;
    }
}
