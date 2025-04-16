package com.bookstore;

import com.bookstore.config.AppConfig;
import com.bookstore.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService orderService = context.getBean(OrderService.class);
        orderService.placeOrder("11");

        ((AnnotationConfigApplicationContext) context).close();

    }
}
