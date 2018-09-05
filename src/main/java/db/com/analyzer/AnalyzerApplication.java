package db.com.analyzer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableKafka
@EnableScheduling
public class AnalyzerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnalyzerApplication.class, args);
    }

    @KafkaListener(topics = "test", groupId = "random")
    public void listen(String message) {
        System.out.println("Received Messasge in group foo: " + message);
    }

    @Bean
    public ConsumerFactory<Long, String> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                "localhost:9092");
        props.put(
                ConsumerConfig.GROUP_ID_CONFIG,
                "random");
        props.put(
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                LongDeserializer.class);
        props.put(
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(props);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<Long, String>
    kafkaListenerContainerFactory() {

        ConcurrentKafkaListenerContainerFactory<Long, String> factory
                = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
