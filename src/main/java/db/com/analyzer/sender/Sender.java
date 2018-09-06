package db.com.analyzer.sender;

import db.com.analyzer.message.Message;

public interface Sender {
    void sendMessage(Message message);
}
