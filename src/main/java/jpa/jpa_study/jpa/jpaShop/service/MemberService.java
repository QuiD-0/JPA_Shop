package jpa.jpa_study.jpa.jpaShop.service;

import jpa.jpa_study.jpa.jpaShop.api.dto.QueryDto;
import jpa.jpa_study.jpa.jpaShop.domain.Member;

import java.util.List;

public interface MemberService {

    Long join(Member member);

    List<Member> findMembers();

    Member findOne(Long id);

    void update(Long id, String name);

    List<QueryDto> findDto();
}
