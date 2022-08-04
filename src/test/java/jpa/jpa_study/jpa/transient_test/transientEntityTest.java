package jpa.jpa_study.jpa.transient_test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest
class transientEntityTest {

    @Autowired
    TransientRepo transientRepo;

    @Test
    public void test() {
        TransientEntity entity = new TransientEntity();
        entity.setName("test");
        entity.add("1");
        entity.add("2");
        transientRepo.save(entity);
        System.out.println(entity);
        TransientEntity findEntity = transientRepo.find(entity.getId());
        System.out.println("findEntity = " + findEntity);
        // transaction 별로 찾아오기때문에 다른 트랜잭션에서는 transient 속성 값을 가져올수없다.
    }
}