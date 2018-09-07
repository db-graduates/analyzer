package db.com.analyzer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

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
