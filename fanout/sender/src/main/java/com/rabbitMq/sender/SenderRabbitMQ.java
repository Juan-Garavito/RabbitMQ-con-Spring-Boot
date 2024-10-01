package com.rabbitMq.sender;


import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
@EnableScheduling
public class SenderRabbitMQ {

    private RabbitTemplate rabbitTemplate;
    private FanoutExchange fanoutExchange;
    private Integer count;

    public SenderRabbitMQ(RabbitTemplate rabbitTemplate, FanoutExchange fanoutExchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.fanoutExchange = fanoutExchange;
        this.count = -1;
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send(){
        String mensaje = "Hola my bro ";
        count++;
        mensaje = mensaje + String.valueOf(count);
        rabbitTemplate.convertAndSend(fanoutExchange.getName(), "", mensaje);
        System.out.println(STR."Mensaje enviado \{mensaje}");
    }

}
