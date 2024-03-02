package org.exam.kafkaconsumer.kafka;

import org.exam.kafkaconsumer.KafkaConsumerApplication;
import org.exam.kafkaconsumer.config.KafkaConsumerConfig;
import org.exam.kafkaconsumer.config.KafkaProducerConfig;
import org.exam.kafkaconsumer.config.KafkaTopicConfig;
import org.exam.kafkaconsumer.domain.NotificationDto;
import org.exam.kafkaconsumer.domain.NotificationEntity;
import org.exam.kafkaconsumer.repository.NotificationRepository;
import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.utility.DockerImageName;

import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@Import({KafkaConsumerConfig.class, KafkaProducerConfig.class, KafkaTopicConfig.class})
@DirtiesContext
@SpringBootTest(classes = KafkaConsumerApplication.class)
class KafkaConsumerTest {

    @Autowired
    private NotificationRepository notificationRepository;

    @ClassRule
    public static KafkaContainer kafka =
            new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:latest"));

    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private KafkaConsumer kafkaConsumer;

    @Test
    void testKafkaConsumer() throws InterruptedException {

        NotificationDto n =  notificationDto();
        kafkaProducer.send(n);

        sleep(3000);
        List<NotificationEntity> all = notificationRepository.findAll();
        assertEquals("test notification", all.get(0).getDescription());

    }

    private NotificationDto notificationDto() {
        return new NotificationDto("test notification");
    }

}