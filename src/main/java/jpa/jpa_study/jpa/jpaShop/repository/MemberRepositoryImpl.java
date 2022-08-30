package jpa.jpa_study.jpa.jpaShop.repository;

import jpa.jpa_study.jpa.jpaShop.api.dto.QueryDto;
import jpa.jpa_study.jpa.jpaShop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {

    private final EntityManager em;

    @Override
    public void save(Member member) {
        em.persist(member);
    }

    @Override
    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m").getResultList();
    }

    @Override
    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name ").setParameter("name", name).getResultList();
    }

    @Override
    public List<QueryDto> findMemberDto() {
        return em.createQuery("select new jpa.jpa_study.jpa.jpaShop.api.dto.QueryDto(m.id,m.name) from Member m",QueryDto.class).getResultList();
    }
}
