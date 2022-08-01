package jpa.jpa_study.jpa.time;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest
@EnableJpaAuditing
class TimeEntityTest {

    @PersistenceContext
    EntityManager em;

    @Test
    @Transactional
    @Rollback(false)
    public void TimeTest() {
        TimeEntity timeEntity = new TimeEntity();
        em.persist(timeEntity);
        System.out.println(timeEntity);
        timeEntity.setData("a");
        System.out.println(timeEntity);
        em.flush();
    }
}