package dev.danilovich.demo1.repository;

import dev.danilovich.demo1.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository extends JpaRepository<Order, Long> {
}
