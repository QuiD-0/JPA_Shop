package jpa.jpa_study.jpa.transient_test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class transientEntityTest {

    @PersistenceContext
    EntityManager em;

    @Test
    public void test(){
        TransientEntity entity = new TransientEntity();
        entity.setName("test");
        entity.add("1");
        entity.add("2");
        em.persist(entity);
        System.out.println(entity);
        TransientEntity findEntity = em.find(TransientEntity.class,entity.getId());
        System.out.println("findEntity = " + findEntity);
    }
}