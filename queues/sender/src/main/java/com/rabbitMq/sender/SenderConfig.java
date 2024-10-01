package com.rabbitMq.sender;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderConfig {

    @Bean
    public Queue createExchange(){
        return  new Queue("hello");
    }
}
