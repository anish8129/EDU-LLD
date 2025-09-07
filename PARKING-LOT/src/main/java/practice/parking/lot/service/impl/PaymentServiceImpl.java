/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package practice.parking.lot.service.impl;

import practice.parking.lot.payment.methods.Cash;
import practice.parking.lot.payment.methods.CreditCard;
import practice.parking.lot.payment.methods.PaymentMethod;
import practice.parking.lot.service.PaymentService;

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
