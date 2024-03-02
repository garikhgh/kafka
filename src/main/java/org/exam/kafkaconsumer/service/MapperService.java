package org.exam.kafkaconsumer.service;

import org.exam.kafkaconsumer.domain.NotificationDto;
import org.exam.kafkaconsumer.domain.NotificationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface MapperService {

    NotificationDto toNotificationDto(NotificationEntity notification);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    NotificationEntity toNotificationEntity(NotificationDto notificationDto);
}
