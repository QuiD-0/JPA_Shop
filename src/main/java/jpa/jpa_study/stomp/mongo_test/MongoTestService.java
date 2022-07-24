package jpa.jpa_study.stomp.mongo_test;

import jpa.jpa_study.stomp.model.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Test;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MongoTestService {

    private final MongoTestRepository mongoTestRepository;

    public TestEntity test(TestEntity testEntity) {
        return mongoTestRepository.save(testEntity);
    }

    public List<TestEntity> findAllChat(String roomId){
        return mongoTestRepository.findAllByRoomIdOrderByTime(roomId);
    }
}
