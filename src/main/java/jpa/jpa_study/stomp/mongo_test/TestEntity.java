package jpa.jpa_study.stomp.mongo_test;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Document(collection = "chat")
@Getter
@Setter
public class TestEntity {

    @Id
    private String id;

    private MessageType type;

    //채팅방 ID
    private String roomId;

    //보내는 사람
    private String sender;

    //내용
    private String message;

    @Override
    public String toString() {
        return "TestEntity{" + "id='" + id + '\'' + ", type=" + type + ", roomId='" + roomId + '\'' + ", sender='" + sender + '\'' + ", message='" + message + '\'' + '}';
    }

    public enum MessageType {
        ENTER, TALK, OUT
    }
}
