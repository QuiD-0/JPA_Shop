package jpa.jpa_study.stomp.mongo_test;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MongoTestRepository extends MongoRepository<TestEntity,String> {
    TestEntity save(TestEntity testEntity);
    List<TestEntity> findAllByRoomIdOrderByTime(String roomId, Pageable pageable);
}
