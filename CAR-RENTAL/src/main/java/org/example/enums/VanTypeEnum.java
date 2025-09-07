/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package org.example.enums;

public enum VanTypeEnum {

    PASSENGER(1000),
    CARGO(1000);

    int rate;

    VanTypeEnum(int rate) {
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }
}
