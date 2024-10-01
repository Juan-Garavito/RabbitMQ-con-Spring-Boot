package com.rabbitMq.sender;


import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
@EnableScheduling
public class SenderRabbitMQ {

    private RabbitTemplate rabbitTemplate;
    private DirectExchange directExchange;
    private Integer count;

    public SenderRabbitMQ(RabbitTemplate rabbitTemplate, DirectExchange directExchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.directExchange = directExchange;
        this.count = 0;
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send(){
        String mensaje = "Hola my bro ";
        count++;
        var topic = count % 2 == 0 ?  "receiver_1" :  "receiver_2";
        mensaje = mensaje + String.valueOf(count);
        rabbitTemplate.convertAndSend(directExchange.getName(), topic, mensaje);
        System.out.println(STR."Mensaje enviado \{mensaje}");
    }

}
