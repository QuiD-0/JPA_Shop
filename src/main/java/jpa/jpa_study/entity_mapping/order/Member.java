package jpa.jpa_study.entity_mapping.order;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MEMBER")
public class Member {

    @Id
    @Column(name = "member_id")
    @GeneratedValue
    private Long id;

    private String name;

    private String city;

    private String street;

    private String zipcode;
}
