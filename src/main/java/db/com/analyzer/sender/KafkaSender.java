package db.com.analyzer.sender;

import db.com.analyzer.predict.PredictService;
import db.com.model.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaSender implements Sender {
    private static final Logger LOG = LogManager.getLogger(KafkaSender.class);

    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;
    @Autowired
    private PredictService predictService;

    @Override
    public void sendMessage(Message message) {
        kafkaTemplate.send("pred", predictService.predict(message));
    }
}
