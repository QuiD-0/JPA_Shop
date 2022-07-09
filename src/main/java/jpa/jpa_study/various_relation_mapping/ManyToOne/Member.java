package jpa.jpa_study.various_relation_mapping.ManyToOne;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String username;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    //아래 추가시 양방향
    public void setTeam(Team t) {
        this.team = t;
        if (!t.getMembers().contains(this)) {
            t.getMembers().add(this);
        }
    }
}
