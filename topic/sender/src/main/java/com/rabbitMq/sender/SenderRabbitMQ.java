package com.rabbitMq.sender;


import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
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
    private TopicExchange topicExchange;
    private Integer count;
    private List<String> keys;

    public SenderRabbitMQ(RabbitTemplate rabbitTemplate, TopicExchange topicExchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.topicExchange = topicExchange;
        this.count = -1;
        this.keys = List.of("producer.receiver_1.mensaje","producer.receiver_2.mensaje", "receiver_1.mensaje.oculto");
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send(){
        String mensaje = "Hola my bro ";
        count = count + 1 >= keys.size() ? 0 : count + 1;
        var topic = keys.get(count);
        mensaje = mensaje + String.valueOf(topic);
        rabbitTemplate.convertAndSend(topicExchange.getName(), topic, mensaje);
        System.out.println(STR."Mensaje enviado a \{topic} --> \{mensaje}");
    }

}
