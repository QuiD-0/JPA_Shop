package jpa.jpa_study;

import jpa.jpa_study.jpa.cascade_orphan.Child;
import jpa.jpa_study.jpa.cascade_orphan.Parent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
public class CascadeTest {

    @Autowired
    private EntityManager em;

    @Test
    @Transactional
    public void test() {
        Parent parent = new Parent();
        parent.setName("parent");

        Child child1 = new Child();
        child1.setName("child1");

        Child child2 = new Child();
        child2.setName("child2");

        parent.add_child(child1);
        parent.add_child(child2);

        em.persist(parent);
//        em.remove(parent);

        System.out.println(child1);
        Child child = em.find(Child.class, child1.getId());
        System.out.println(child);
        System.out.println(em.find(Parent.class, parent.getId()));
        System.out.println(parent);
//        child1.setParent(null);
        parent.getChild().remove(child1);
        em.flush();
    }
}
