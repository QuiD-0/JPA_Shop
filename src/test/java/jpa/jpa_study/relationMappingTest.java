package jpa.jpa_study;

import jpa.jpa_study.relation_mapping.Member;
import jpa.jpa_study.relation_mapping.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;

@SpringBootTest
public class relationMappingTest {

    @Autowired
    private EntityManager em;

    @Test
    @Transactional
    public void relationMappingTest() {
        Team team1 = Team.builder().name("팀1").memberList(new ArrayList<>()).build();
        em.persist(team1);

        Member member1 = Member.builder().name("화원1").build();
        member1.setTeam(team1);
        em.persist(member1);

        Member member2 = Member.builder().name("화원2").build();
        member2.setTeam(team1);
        em.persist(member2);

        System.out.println("members = " + team1.getMemberList());
        System.out.println("member1 = " + member1);
        System.out.println(member1.getTeam().getName());

        Team team2 = Team.builder().name("팀2").memberList(new ArrayList<>(){}).build();
        em.persist(team2);
        member1.setTeam(team2);

        System.out.println("member1 = " + member1);
        System.out.println(member1.getTeam().getName());

        Member member3 = em.find(Member.class, member1.getId());
        member3.setTeam(null);

        System.out.println("member3 = " + member3);
        System.out.println(member3.getTeam());

//        em.flush();
//        em.clear();

        Team team3 = em.find(Team.class, team1.getId());
        System.out.println("team3 = " + team3.getMemberList());
    }

}
