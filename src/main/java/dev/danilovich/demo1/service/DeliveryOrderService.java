package dev.danilovich.demo1.service;

import dev.danilovich.demo1.exception.OrderNotFoundException;
import dev.danilovich.demo1.model.Order;
import dev.danilovich.demo1.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryOrderService {
    private final PaymentProcessor paymentProcessor;
    private final OrderRepository orderRepository;

    public DeliveryOrderService(PaymentProcessor paymentProcessor, OrderRepository orderRepository) {
        this.paymentProcessor = paymentProcessor;
        this.orderRepository = orderRepository;
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

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
