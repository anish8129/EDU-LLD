/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package practice.parking.lot.service;

public interface PaymentService {
    void acceptCashPayment(int amount);
    void acceptCardPayment(String cardNumber, int cvv, int amount);
}
