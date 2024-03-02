package org.exam.kafkaconsumer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.exam.kafkaconsumer.domain.NotificationDto;
import org.exam.kafkaconsumer.domain.NotificationEntity;
import org.exam.kafkaconsumer.repository.NotificationRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final MapperService mapperService;

    public void storeNotification(NotificationDto notificationDto) {
        NotificationEntity notificationEntity = mapperService.toNotificationEntity(notificationDto);
        NotificationEntity save = notificationRepository.save(notificationEntity);
        log.info("New Notification is saved: {}", save.toString());
    }

}
