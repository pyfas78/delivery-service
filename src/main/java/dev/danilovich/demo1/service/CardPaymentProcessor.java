package dev.danilovich.demo1.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class CardPaymentProcessor implements PaymentProcessor {

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Оплата с карты на сумму: " + amount);
        return true;
    }

    @PostConstruct
    public void init() {
        System.out.println(">>> Связь с процессинговым центром банка установлена!");
    }

    @PreDestroy
    public void destroy() {
        System.out.println(">>> Сессия с банком закрыта корректно.");
    }
}
