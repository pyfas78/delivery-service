package dev.danilovich.demo1;

import dev.danilovich.demo1.service.DeliveryOrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Demo1Application {

    public static void main(String[] args) {
       ApplicationContext context =
               SpringApplication.run(Demo1Application.class, args);

        DeliveryOrderService orderService =
                context.getBean(DeliveryOrderService.class);

        orderService.checkOut("Banana", 1200);
    }

}
