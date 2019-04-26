package com.example.functiondemo;

import java.math.BigDecimal;
import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FunctionDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FunctionDemoApplication.class, args);
    }

    // call with
    // curl localhost:8080 -H "Content-Type: application/json" -d '{"years":30, "amount":100000, "rate":3.5}' -w '\n'
    @Bean
    public Function<PaymentCalculator, BigDecimal> payment() {
        return PaymentCalculator::calculatePayment;
    }
}
