package com.rabbitMq.sender;


import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@EnableScheduling
public class SenderRabbitMQ {

    private RabbitTemplate rabbitTemplate;
    private Queue queue;

    private Integer count;


    public SenderRabbitMQ(RabbitTemplate rabbitTemplate, Queue queue) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
        this.count = -1;
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send(){
        String mensaje = "Hola my bro ";
        count++;
        mensaje = mensaje + String.valueOf(count);
        rabbitTemplate.convertAndSend(queue.getName(), mensaje);
        System.out.println(STR."Mensaje enviado \{mensaje}");
    }

}
