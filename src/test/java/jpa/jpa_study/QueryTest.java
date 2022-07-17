package jpa.jpa_study;

import jpa.jpa_study.jpaShop.domain.Address;
import jpa.jpa_study.jpaShop.domain.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@SpringBootTest
public class QueryTest {

    @Autowired
    private EntityManager em;

    @BeforeEach
    public void before() {
        Member member1 = new Member();
        member1.setName("member1");
        member1.setAddress(new Address("seoul", "jongro", "123123"));

        Member member2 = new Member();
        member2.setName("member2");
        member2.setAddress(new Address("seoul", "gangnam", "123123"));

        Member member3 = new Member();
        member3.setName("member3");
        member3.setAddress(new Address("busan", "sasang", "123123"));

        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
    }

    @Test
    @Transactional
    public void JPQL_Test() {
        List<Member> members = em.createQuery("select m from Member m where m.address.city = :city", Member.class).setParameter("city", "seoul").getResultList();
        System.out.println("members = " + members);
    }

    @Test
    @Transactional
    public void Criteria_Test() {
        CriteriaQuery<Member> cb = em.getCriteriaBuilder().createQuery(Member.class);
        Root<Member> m = cb.from(Member.class);
        List<Member> members = em.createQuery(cb.select(m).where(em.getCriteriaBuilder().equal(m.get("address").get("city"), "seoul"))).getResultList();
        System.out.println("members = " + members);
    }
}
