package jpa.jpa_study.jpa.mysql_test;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class MySqlTestRepository {

    private final EntityManager em;

    public TestEntity test(TestEntity testEntity) {
        em.persist(testEntity);
        return testEntity;
    }
}
