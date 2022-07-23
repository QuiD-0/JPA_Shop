package jpa.jpa_study.jpa.mysql_test;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MysqlTestService {

    private final MySqlTestRepository mySqlTestRepository;

    public TestEntity test() {
        TestEntity testEntity = new TestEntity();
        testEntity.setName("lee");
        return mySqlTestRepository.test(testEntity);
    }
}
