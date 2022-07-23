package jpa.jpa_study.stomp.mongo_test;

import jpa.jpa_study.stomp.model.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MongoTestService {

    private final MongoTestRepository mongoTestRepository;

    public TestEntity test(ChatMessage message) {
        TestEntity testEntity = new TestEntity();
        testEntity.setMessage(message.getMessage());
        testEntity.setSender(message.getSender());
        testEntity.setType(TestEntity.MessageType.TALK);
        testEntity.setRoomId(message.getRoomId());
        return mongoTestRepository.save(testEntity);
    }

    public List<TestEntity> findAllChat(String roomId){
        return mongoTestRepository.findAllByRoomId(roomId);
    }
}
