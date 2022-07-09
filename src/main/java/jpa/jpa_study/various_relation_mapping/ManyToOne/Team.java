package jpa.jpa_study.various_relation_mapping.ManyToOne;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

//@Entity
@Getter
@Setter
public class Team {

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;

    // 아래 추가시 양방향
    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();

    public void setMember(Member m) {
        this.members.add(m);
        if (m.getTeam() != this) {
            m.setTeam(this);
        }
    }
}
