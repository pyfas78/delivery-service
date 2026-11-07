package dev.danilovich.demo1.OrderController;

import dev.danilovich.demo1.dto.OrderRequest;
import dev.danilovich.demo1.model.Order;
import dev.danilovich.demo1.service.DeliveryOrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final DeliveryOrderService deliveryOrderService;

    public OrderController(DeliveryOrderService deliveryOrderService) {
        this.deliveryOrderService = deliveryOrderService;
    }

    @GetMapping("/info")
    public String info() {
        return "Delivery Service v1.0";
    }

    @GetMapping
    public List<Order> getOrders() {
        return deliveryOrderService.getAllOrders();
    }

    @GetMapping("{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok().body(deliveryOrderService.getOrderById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        deliveryOrderService.deleteOrderById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{dishName}")
    public List<Order> getOrdersByDishName(@PathVariable String dishName) {
        return deliveryOrderService.getOrderByDishName(dishName);
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@Valid @RequestBody OrderRequest orderRequest) {
        Order order = deliveryOrderService.createOrder(orderRequest.dishName(), orderRequest.price());
        if(order.isPaid()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(order);
        } else {
            return ResponseEntity.badRequest().body(order);
        }
    }
}
