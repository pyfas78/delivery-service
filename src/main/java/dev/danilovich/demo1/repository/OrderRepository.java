package dev.danilovich.demo1.repository;

import dev.danilovich.demo1.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByDishNameContainingIgnoreCase(String dishName);
}
