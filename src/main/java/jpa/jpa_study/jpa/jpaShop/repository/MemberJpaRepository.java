package jpa.jpa_study.jpa.jpaShop.repository;

import jpa.jpa_study.jpa.jpaShop.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member,Long> {

}
