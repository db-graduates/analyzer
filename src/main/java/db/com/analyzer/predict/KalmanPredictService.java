package db.com.analyzer.predict;

import db.com.model.Message;
import org.springframework.stereotype.Component;

@Component
public class KalmanPredictService implements PredictService {
    private final double minErrorEstimation = 0.00001;
    private double errorEstimation;
    private double estimation;

    @Override
    public Message predict(Message message) {
        Message message1 = new Message();
        // this code is left as it is in DummyPredictService.java
        // value estimation implemented  below this code
        message1.setHigh(message.getHigh());
        message1.setClose(message.getClose());
        message1.setLow(message.getLow());
        message1.setOpen(message.getOpen());
        message1.setVolume(message.getVolume());
        message1.setDate(message.getDate());
        message1.setId(message.getId());

        // main idea is to make estimation of the next step value through simple kalman algorithm.
        double errorValue = calculateError(message);
        double kalmanGain = errorValue / (errorValue + errorEstimation);
        estimation = estimation + kalmanGain * (message.getValue() - estimation);
        errorEstimation = (1 - kalmanGain) * errorEstimation;
        message1.setValue(estimation);
        return message1;
    }

    // it's a custom constructed error function depending on your imagination and common sense
    // yours could be different
    private double calculateError(Message message){
        double calculatedError = Math.max((message.getHigh() - message.getLow()) / 2,
                Math.abs(message.getOpen() - message.getClose()));
        return Math.max(calculatedError / 10000, minErrorEstimation);
    }
}
