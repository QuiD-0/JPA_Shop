package jpa.jpa_study.stomp.mongo_test;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MongoTestService {

    private final MongoTestRepository mongoTestRepository;
    public TestEntity test() {
        TestEntity testEntity = new TestEntity();
        testEntity.setName("kim");
        return mongoTestRepository.save(testEntity);
    }
}
