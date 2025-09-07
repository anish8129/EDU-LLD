package org.example.dto.payment;

import org.example.enums.PaymentStatus;

public class CreditCard extends Payment {
    private String nameOnCard;
    private String cardNumber;
    private String billingAddress;
    private int code;
    // Setters...
    @Override
    public boolean makePayment() { setStatus(PaymentStatus.COMPLETED); return true; }
}
