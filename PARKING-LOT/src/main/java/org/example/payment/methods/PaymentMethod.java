/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package org.example.payment.methods;

public abstract class PaymentMethod {

    public abstract boolean initiatePayment(int amount);
}
