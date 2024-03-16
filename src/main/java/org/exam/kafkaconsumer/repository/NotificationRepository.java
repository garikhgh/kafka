package org.exam.kafkaconsumer.repository;

import org.exam.kafkaconsumer.domain.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import static org.exam.kafkaconsumer.repository.NotificationRepository.notification;

@RepositoryRestResource(collectionResourceRel = notification, path = notification)
public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {
    String notification = "notification";
}
