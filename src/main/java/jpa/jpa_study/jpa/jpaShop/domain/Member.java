package jpa.jpa_study.jpa.jpaShop.domain;

import jpa.jpa_study.jpa.jpaShop.api.MemberApiController;
import jpa.jpa_study.jpa.jpaShop.api.dto.MemberDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @NotEmpty
    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member") // 읽기 전용
    private List<Order> orders = new ArrayList<>();

    public MemberDto convertToMemberDto() {
        return MemberDto.builder().name(name).build();
    }

    @Override
    public String toString() {
        return "Member{" + "id=" + id + ", name='" + name + '\'' + ", address=" + address + '}';
    }
}
