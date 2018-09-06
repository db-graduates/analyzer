package db.com.analyzer;

import com.fasterxml.jackson.databind.ObjectMapper;
import db.com.analyzer.message.Message;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableKafka
@EnableScheduling
public class AnalyzerApplication {
    public static void main(String[] args)
    {
        ConfigurableApplicationContext context = SpringApplication.run(AnalyzerApplication.class, args);
        context.getBean(KafkaTemplate.class);
        System.out.println();
    }
}
