package org.car.rental.dto.payment;

import org.car.rental.enums.PaymentStatus;

public class Cash extends Payment {
    @Override
    public boolean makePayment() { setStatus(PaymentStatus.COMPLETED); return true; }
}