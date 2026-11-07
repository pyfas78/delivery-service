package dev.danilovich.demo1.OrderController;

import dev.danilovich.demo1.dto.OrderRequest;
import dev.danilovich.demo1.model.Model;
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
    public List<Model> getOrders() {
        return deliveryOrderService.getAllOrders();
    }

    @GetMapping("{id}")
    public ResponseEntity<Model> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok().body(deliveryOrderService.getOrderById(id));
    }

    @PostMapping
    public ResponseEntity<Model> createOrder(@Valid @RequestBody OrderRequest orderRequest) {
        Model order = deliveryOrderService.createOrder(orderRequest.dishName(), orderRequest.price());
        if(order.paid()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(order);
        } else {
            return ResponseEntity.badRequest().body(order);
        }
    }
}
