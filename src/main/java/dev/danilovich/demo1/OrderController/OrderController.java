package dev.danilovich.demo1.OrderController;

import dev.danilovich.demo1.dto.OrderRequest;
import dev.danilovich.demo1.dto.OrderResponse;
import dev.danilovich.demo1.service.DeliveryOrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@Valid @RequestBody OrderRequest orderRequest) {
        boolean isPaid = deliveryOrderService.checkOut(orderRequest.dishName(), orderRequest.price());
        if(isPaid) {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(new OrderResponse(true, "Order has been created: " + orderRequest.dishName()));
        } else {
            return ResponseEntity
                    .badRequest()
                    .body(new OrderResponse(false, "Order hasn't been created - payment failed"));
        }
    }
}
