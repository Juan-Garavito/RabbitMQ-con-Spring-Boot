package com.rabbitmq.receiver2;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = "hello")
@Component
public class Receiver {

    @RabbitHandler
    public void mensajeRecibido(String message){
        System.out.println("Receiver 2: " + message);
    }
}
