package ro.poc.kafka_dummy_producer.resource;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ro.poc.kafka_dummy_producer.config.KafkaTopicsConfig;
import ro.poc.kafka_dummy_producer.messaging.EventsProducer;
import ro.poc.kafka_dummy_producer.model.KafkaEvent;
import ro.poc.kafka_dummy_producer.model.OrderModel;
import ro.poc.kafka_dummy_producer.service.EventGeneratorService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);
    private final EventsProducer eventsProducer;
    private final EventGeneratorService eventGeneratorService;
    private final KafkaTopicsConfig kafkaTopicsConfig;

    @PostMapping("/generate")
    public String generateDocuments(@RequestParam final Integer size) {
        final List<KafkaEvent<OrderModel>> kafkaEvents = eventGeneratorService.generateOrders(size);
        log.info("Generated {} orders", kafkaEvents.size());
        final Boolean success = eventsProducer.send(kafkaEvents, kafkaTopicsConfig.getOrdersTopic());
        return success ? "Success" : "Failed";
    }
}
