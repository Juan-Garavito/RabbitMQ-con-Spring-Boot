package com.rabbitMq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = "#{anonymousQueue.name}")
@Component
public class ReceiverRabbitMQ {

    @RabbitHandler
    public Integer receiver(Integer number){
        System.out.println("Numero recibido: " + number);
        Integer resultado = fibonacci(number);
        System.out.println("Resultado enviado: " + resultado);
        return resultado;
    }

    public Integer fibonacci(Integer number){
        return number == 0 ? 0 : number == 1 ? 1 : (fibonacci(number - 1) + fibonacci(number - 2));
    }
}
