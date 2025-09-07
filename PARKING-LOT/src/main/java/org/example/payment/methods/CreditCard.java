/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package org.example.payment.methods;

public class CreditCard extends PaymentMethod {
    String cardNumber;
    int cvv;

    public CreditCard(String cardNumber, int cvv) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    @Override
    public boolean initiatePayment(int amount) {
        return true;
    }
}
