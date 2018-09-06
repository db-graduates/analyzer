package db.com.analyzer.predict;

import db.com.analyzer.message.Message;

public interface PredictService {
    Message predict(Message message);
}
