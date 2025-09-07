/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package org.example.dto.assistnace;

import org.example.dto.user.Driver;

public class DriverAssistance extends Assistance {
    Driver driver;

    @Override
    public double getCost() {
        return 1000;
    }
}
