package dev.danilovich.demo1.service;

import org.springframework.stereotype.Service;

@Service
public class CashPaymentProcessor implements PaymentProcessor {

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Оплата наликом на сумму: " + amount);
        return true;
    }
}
