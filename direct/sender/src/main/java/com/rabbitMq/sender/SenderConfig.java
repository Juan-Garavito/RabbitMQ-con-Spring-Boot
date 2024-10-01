package com.rabbitMq.sender;


import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderConfig {

    @Bean
    public DirectExchange createExchange(){
        return  new DirectExchange("hello");
    }
}
