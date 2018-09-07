package db.com.analyzer.sender;


import db.com.model.Message;

public interface Sender {
    void sendMessage(Message message);
}
