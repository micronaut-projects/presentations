package kafka.producer.demo;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.micronaut.context.event.ShutdownEvent;
import io.micronaut.messaging.annotation.MessageBody;
import io.micronaut.runtime.event.annotation.EventListener;
import io.micronaut.scheduling.annotation.Scheduled;
import jakarta.inject.Singleton;
import net.datafaker.Faker;


@Singleton
public class ProducerJob {

    private final SimpleProducer producer;
    private final Faker faker = new Faker();
    private boolean running = true;

    public ProducerJob(SimpleProducer producer) {
        this.producer = producer;
    }

    @Scheduled(fixedDelay = "1s")
    void produce() {
        producer.send(
                faker.name().fullName(),
                faker.pokemon().name()
        );
    }

    @EventListener
    void stop(ShutdownEvent shutdownEvent) {
        this.running = false;
    }
}

@KafkaClient
interface SimpleProducer {

    @Topic("emails")
    void send(@KafkaKey String to, @MessageBody String body);
}