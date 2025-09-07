/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package org.car.rental.dto.vehicle;

import java.util.Date;
import org.car.rental.enums.Features;
import org.car.rental.enums.VanTypeEnum;

public class Car extends Vehicle {

    public Car(int vehicleNo, Date dateOfRegistration, VanTypeEnum vehicleType,
            boolean isFree, String model, Features features) {
        super(vehicleNo, dateOfRegistration, vehicleType, isFree, model, features);
    }

    @Override
    public double getRentalCost() {
        return vehicleType.getRate();
    }
}
