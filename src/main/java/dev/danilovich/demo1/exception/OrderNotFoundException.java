package dev.danilovich.demo1.exception;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long id) {
        super("Заказ с ID: " + id + " не найден!");
    }
}
