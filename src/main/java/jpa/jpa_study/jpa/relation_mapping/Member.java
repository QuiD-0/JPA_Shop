package jpa.jpa_study.jpa.relation_mapping;

import lombok.*;

import javax.persistence.*;

//@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public void setTeam(Team team) {
        if (this.team != null || team == null) {
            this.team.getMemberList().remove(this);
        } else {
            team.getMemberList().add(this);
        }
        this.team = team;
    }
}
