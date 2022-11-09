package jpa.jpa_study.jpa.noRelationTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NoRelationRepositoryTest {

    @Autowired
    NoRelationRepository noRelationRepository;

    @Test
    void test() {
        noRelationRepository.findSchool().forEach(System.out::println);
    }


}