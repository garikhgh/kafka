package org.exam.kafkaconsumer.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.exam.kafkaconsumer.domain.NotificationDto;
import org.exam.kafkaconsumer.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class NotificationController {

    private final KafkaProducer kafkaProducer;

    @PostMapping("/notification")
    public ResponseEntity<Void> createNotification(@RequestBody NotificationDto notificationDto) {
        log.info("Storing new notification {}", notificationDto);
        kafkaProducer.send(notificationDto);
        log.info("Notification is stored");
        return ResponseEntity.accepted().build();
    }
}
