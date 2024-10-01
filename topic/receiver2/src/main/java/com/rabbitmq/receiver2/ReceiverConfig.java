package com.rabbitmq.receiver2;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReceiverConfig {

    @Bean
    public TopicExchange createExchange(){
        return  new TopicExchange("hello");
    }

    @Bean
    public AnonymousQueue anonymousQueue(){
        return new AnonymousQueue();
    }

    @Bean
    public Binding createBinding(TopicExchange topicExchange, AnonymousQueue anonymousQueue){
        return BindingBuilder.bind(anonymousQueue).to(topicExchange).with("*.receiver_2.*");
    }

}
