/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package org.car.rental.dto.assistnace;

import org.car.rental.dto.user.Driver;

public class DriverAssistance extends Assistance {
    Driver driver;

    @Override
    double getCost() {
        return 1000;
    }
}
