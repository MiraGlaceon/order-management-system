package mira.space.oms.producers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mira.space.oms.domen.dto.KafkaMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {

    @Value("${kafka.topics.test-topic}")
    private String topic;

    private final KafkaTemplate<Object, Object> kafkaTemplate;

    public void sendMessage() {
        int messageCount = 0;
        while (messageCount != 10000) {
            messageCount++;
            KafkaMessage message = new KafkaMessage(messageCount, "message number: " + messageCount);
            kafkaTemplate.send(topic, String.valueOf(ThreadLocalRandom.current().nextLong()), message);
            log.debug("Sent message with number: {}", messageCount);
        }
    }
}
