/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package org.example.payment.methods;

public class Cash extends PaymentMethod {

    public Cash() {
    }

    @Override
    public boolean initiatePayment(int amount) {
        return true;
    }
}
