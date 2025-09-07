package org.example.dto.payment;

import org.example.enums.PaymentStatus;

public class Cash extends Payment {
    @Override
    public boolean makePayment() { setStatus(PaymentStatus.COMPLETED); return true; }
}