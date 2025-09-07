package org.example.dto.payment;

import java.util.Date;
import org.example.enums.PaymentStatus;

public abstract class Payment {
    private double amount;
    private Date timestamp;
    private PaymentStatus status;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public abstract boolean makePayment();
}