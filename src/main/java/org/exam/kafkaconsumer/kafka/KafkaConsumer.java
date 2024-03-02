package org.exam.kafkaconsumer.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.exam.kafkaconsumer.domain.NotificationDto;
import org.exam.kafkaconsumer.domain.NotificationEntity;
import org.exam.kafkaconsumer.service.NotificationService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {

    private final NotificationService notificationService;
    @KafkaListener(topics = "product", containerFactory = "kafkaListenerContainerFactory")
    public void notificationListener(NotificationDto notificationDto) {
        log.info("New Notification received {}", notificationDto.toString());
        notificationService.storeNotification(notificationDto);
    }
}
