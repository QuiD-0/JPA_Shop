package jpa.jpa_study.stomp.mongo_test;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MongoTestService {

    private final MongoTestRepository mongoTestRepository;

    public TestEntity test(TestEntity testEntity) {
        return mongoTestRepository.save(testEntity);
    }

    public List<TestEntity> findAllChat(String roomId, Pageable pageable) {
        return mongoTestRepository.findAllByRoomIdOrderByTime(roomId, pageable);
    }
}
