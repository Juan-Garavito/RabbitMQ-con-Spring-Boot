package com.rabbitMq.receiver;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Queue;

@Configuration
public class ReceiverConfig {

    @Bean
    public FanoutExchange createExchange(){
        return  new FanoutExchange("hello");
    }

    @Bean
    public AnonymousQueue anonymousQueue(){
        return new AnonymousQueue();
    }

    @Bean
    public Binding createBinding(FanoutExchange fanoutExchange, AnonymousQueue anonymousQueue){
        return BindingBuilder.bind(anonymousQueue).to(fanoutExchange);
    }


}
