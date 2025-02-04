package com.rabbitMq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = "#{anonymousQueue.name}")
@Component
public class ReceiverRabbitMQ {

    @RabbitHandler
    public void receiver(String message){
        System.out.println("Receiver 1 : " + message);
    }
}
