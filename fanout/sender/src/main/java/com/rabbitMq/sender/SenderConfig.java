package com.rabbitMq.sender;


import org.springframework.amqp.core.FanoutExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderConfig {

    @Bean
    public FanoutExchange createExchange(){
        return  new FanoutExchange("hello");
    }
}
