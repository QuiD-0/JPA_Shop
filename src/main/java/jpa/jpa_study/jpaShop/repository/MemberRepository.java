package jpa.jpa_study.jpaShop.repository;

import jpa.jpa_study.jpaShop.domain.Member;

import java.util.List;

public interface MemberRepository {

    void save(Member member);
    Member findOne(Long id);
    List<Member> findAll();
    List<Member> findByName(String name);

}
