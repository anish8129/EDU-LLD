/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package org.example.service.impl;

import org.example.payment.methods.Cash;
import org.example.payment.methods.CreditCard;
import org.example.payment.methods.PaymentMethod;
import org.example.service.PaymentService;

public class PaymentServiceImpl  implements PaymentService {

    @Override
    public void acceptCashPayment(int amount) {
        PaymentMethod paymentMethod = new Cash();
        paymentMethod.initiatePayment(amount);

    }

    @Override
    public void acceptCardPayment(String cardNumber, int cvv, int amount) {
        PaymentMethod paymentMethod = new CreditCard(cardNumber, cvv);
        paymentMethod.initiatePayment(amount);
    }
}
