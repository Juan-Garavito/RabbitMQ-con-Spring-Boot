package com.rabbitMq.receiver;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Queue;

@Configuration
public class ReceiverConfig {

    @Bean
    public DirectExchange createExchange(){
        return  new DirectExchange("hello");
    }

    @Bean
    public AnonymousQueue anonymousQueue(){
        return new AnonymousQueue();
    }

    @Bean
    public Binding createBinding(DirectExchange directExchange, AnonymousQueue anonymousQueue){
        return BindingBuilder.bind(anonymousQueue).to(directExchange).with("receiver_1");
    }


}
