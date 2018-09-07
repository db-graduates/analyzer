package db.com.analyzer.predict;

import db.com.model.Message;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Random;
@Component
public class DummyPredictService implements PredictService {
    public static final Random random = new Random();

    @Override
    public Message predict(Message message) {
        Message message1 = new Message();

        message1.setHigh(generateRandom(message.getHigh()));
        message1.setClose(generateRandom(message.getClose()));
        message1.setLow(generateRandom(message.getLow()));
        message1.setOpen(generateRandom(message.getOpen()));
        message1.setValue(generateRandom(message.getValue()));
        message1.setVolume(generateRandom(message.getVolume()));
        return message1;
    }

    private BigDecimal generateRandom(BigDecimal num){
        double delta = random.nextDouble();
        double multy = random.nextDouble();
        if(delta > 0.5){
            return num.add(num.multiply(BigDecimal.valueOf(0.02).multiply(BigDecimal.valueOf(multy))));
        }else {
            return num.add(num.multiply(BigDecimal.valueOf(0.02).negate().multiply(BigDecimal.valueOf(multy))));
        }
    }
}
