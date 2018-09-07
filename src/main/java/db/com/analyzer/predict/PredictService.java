package db.com.analyzer.predict;


import db.com.model.Message;

public interface PredictService {
    Message predict(Message message);
}
