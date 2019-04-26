package com.example.functiondemo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PaymentCalculator {
    private double amount;
    private double rate;
    private int years;

    public PaymentCalculator(double amount, double rate, int years) {
        this.amount = amount;
        this.rate = rate;
        this.years = years;
    }

    public BigDecimal calculatePayment() {
        if (rate == 0.0) {
            return calculateWithoutInterest();
        } else {
            return calculateWithInterest();
        }
    }

    private BigDecimal calculateWithInterest() {
        double monthlyRate = rate / 100.0 / 12.0;
        int numberOfPayments = years * 12;
        double payment = (monthlyRate * amount) / (1.0 - Math.pow(1.0 + monthlyRate, -numberOfPayments));
        return toMoney(payment);
    }

    private BigDecimal calculateWithoutInterest() {
        int numberOfPayments = years * 12;
        return toMoney(amount / numberOfPayments);
    }

    private BigDecimal toMoney(double d) {
        BigDecimal bd = new BigDecimal(d);
        return bd.setScale(2, RoundingMode.HALF_UP);
    }
}
