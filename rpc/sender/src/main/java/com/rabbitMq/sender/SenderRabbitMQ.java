package com.rabbitMq.sender;


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
    private Integer number;


    public SenderRabbitMQ(RabbitTemplate rabbitTemplate, DirectExchange directExchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.directExchange = directExchange;
        this.number = 0;
    }

    @Scheduled(fixedDelay = 5000, initialDelay = 500)
    public void send(){
        number++;
        Integer valor = (Integer) rabbitTemplate.convertSendAndReceive(directExchange.getName(), "rpc", number);
        System.out.println(STR."El fibonacci de \{number} es -> \{valor}");
    }

}
