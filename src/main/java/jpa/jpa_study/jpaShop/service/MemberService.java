package jpa.jpa_study.jpaShop.service;

import jpa.jpa_study.jpaShop.domain.Member;

import java.util.List;

public interface MemberService {

    Long join(Member member);

    List<Member> findMembers();

    Member findOne(Long id);
}
