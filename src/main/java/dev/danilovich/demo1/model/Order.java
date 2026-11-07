package dev.danilovich.demo1.model;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dishName", nullable = false)
    private String dishName;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "paid?", nullable = false)
    private boolean paid;

    public Order(String dishName, double price, boolean paid) {
        this.dishName = dishName;
        this.price = price;
        this.paid = paid;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
