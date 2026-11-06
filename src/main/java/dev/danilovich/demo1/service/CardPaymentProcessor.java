package dev.danilovich.demo1.service;

import org.springframework.stereotype.Service;

@Service
public class CardPaymentProcessor implements PaymentProcessor {
    public boolean processPayment(double amount) {
        System.out.println("оплата с карты на сумму: " + amount);
        return true;
    }
}
