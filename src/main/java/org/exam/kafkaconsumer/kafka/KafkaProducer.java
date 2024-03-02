package org.exam.kafkaconsumer.kafka;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.exam.kafkaconsumer.domain.NotificationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;

import static java.lang.Thread.sleep;

@Slf4j
@NoArgsConstructor
@Component
public class KafkaProducer {

    final String productTopic = "product";

    private KafkaTemplate<String, Serializable> kafkaTemplate;

    @Autowired
    public void ProductProducer(KafkaTemplate<String, Serializable> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void send(NotificationEntity message) {
        System.out.println("----------------SENT--------------------");
        kafkaTemplate.send(productTopic, message);
        System.out.println("----------------Complete--------------------");
    }

}
