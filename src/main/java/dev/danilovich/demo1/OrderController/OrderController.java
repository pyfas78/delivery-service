package dev.danilovich.demo1.OrderController;

import dev.danilovich.demo1.dto.OrderRequest;
import dev.danilovich.demo1.dto.OrderResponse;
import dev.danilovich.demo1.service.DeliveryOrderService;
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
    public OrderResponse createOrder(@RequestBody OrderRequest orderRequest) {
        deliveryOrderService.checkOut(orderRequest.dishName(), orderRequest.price());
        if (true) {
            return new OrderResponse(true, "Order Created Successfully: " + orderRequest.dishName());
        } else {
            return new OrderResponse(false, "Order Not Created Successfully");
        }
    }
}
