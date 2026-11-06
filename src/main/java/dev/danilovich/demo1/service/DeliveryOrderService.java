package dev.danilovich.demo1.service;

import org.springframework.stereotype.Service;

@Service
public class DeliveryOrderService {
    private final PaymentProcessor paymentProcessor;

    public DeliveryOrderService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public boolean checkOut(String dishName, double price) {
        boolean paid = paymentProcessor.processPayment(price);
        if(paid) {
            System.out.println("Блюдо " + dishName + " успешно заказано");
        } else {
            System.out.println("Ошибка оплаты!");
        }
        return paid;
    }
}
