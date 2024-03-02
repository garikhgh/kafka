package org.exam.kafkaconsumer.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.exam.kafkaconsumer.domain.NotificationDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaProducer {

    private static final String NOTIFICATION_TOPIC = "notification";

    private final KafkaTemplate<String, Serializable> kafkaTemplate;

    public void send(NotificationDto message) {
        kafkaTemplate.send(NOTIFICATION_TOPIC, message);
        log.info("New Notification sending is completed.");
    }

}
