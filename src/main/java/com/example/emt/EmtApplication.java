package com.example.emt;

import com.stripe.Stripe;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class EmtApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmtApplication.class, args);
        Stripe.apiKey="sk_test_qtxcZhc7axpT1Rsh1jIaanrq00gJmUHsE1";
    }

}
