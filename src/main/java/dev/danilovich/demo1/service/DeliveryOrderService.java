package dev.danilovich.demo1.service;

import dev.danilovich.demo1.exception.OrderNotFoundException;
import dev.danilovich.demo1.model.Model;
import dev.danilovich.demo1.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryOrderService {
    private final PaymentProcessor paymentProcessor;
    private final OrderRepository orderRepository;

    public DeliveryOrderService(PaymentProcessor paymentProcessor, OrderRepository orderRepository) {
        this.paymentProcessor = paymentProcessor;
        this.orderRepository = new OrderRepository();
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

    public Model createOrder(String dishName, double price) {
        boolean isPaid = paymentProcessor.processPayment(price);
        return orderRepository.save(dishName,price,isPaid);
    }

    public Model getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

    public List<Model> getAllOrders() {
        return orderRepository.findAll();
    }
}
