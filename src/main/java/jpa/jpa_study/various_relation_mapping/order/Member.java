package jpa.jpa_study.various_relation_mapping.order;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;

    private String city;

    private String street;

    private String zipcode;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    @Override
    public String toString() {
        return "Member{" + "id=" + id + ", name='" + name + '\'' + ", city='" + city + '\'' + ", street='" + street + '\'' + ", zipcode='" + zipcode + '\'' + '}';
    }
}
