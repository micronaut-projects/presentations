package kafka.consumer.demo;

import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.OffsetReset;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.micronaut.messaging.annotation.MessageBody;

@KafkaListener(offsetReset = OffsetReset.EARLIEST)
public class MyConsumer {

    @Topic("emails")
    void receive(@KafkaKey String to, @MessageBody String body) {
        System.out.println("Processing message send to: " + to);
    }
}
