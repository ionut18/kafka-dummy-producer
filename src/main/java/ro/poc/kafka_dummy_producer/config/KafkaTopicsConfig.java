package ro.poc.kafka_dummy_producer.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class KafkaTopicsConfig {

    @Value("${spring.kafka.boostrap-servers}")
    private String bootstrapServers;

    @Value("${spring.kafka.topics.documents}")
    private String documentsTopic;

    @Value("${spring.kafka.topics.orders}")
    private String ordersTopic;
}
