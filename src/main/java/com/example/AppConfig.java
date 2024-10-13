package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    @Bean
    @Scope("prototype")
    public Cart cart() {
        return new Cart();
    }

    @Bean
    public ProductRepository productRepository() {
        return new ProductRepository();
    }
}

