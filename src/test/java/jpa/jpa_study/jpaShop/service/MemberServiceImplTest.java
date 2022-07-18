package jpa.jpa_study.jpaShop.service;

import jpa.jpa_study.jpaShop.domain.Member;
import jpa.jpa_study.jpaShop.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class MemberServiceImplTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 회원가입() {
        //given
        Member member = new Member();
        member.setName("Kim");

        //when
        Long id = memberService.join(member);

        //then
        Assertions.assertEquals(member, memberRepository.findOne(id));
    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("Kim");

        Member member2 = new Member();
        member2.setName("Kim");

        //when
        memberService.join(member1);

        //then
        Assertions.assertThrows(IllegalStateException.class, () -> memberService.join(member2));
    }

}