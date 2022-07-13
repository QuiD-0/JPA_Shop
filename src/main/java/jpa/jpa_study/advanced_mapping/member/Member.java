package jpa.jpa_study.advanced_mapping.member;

import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Setter
public class Member extends BaseEntity{
    private String email;
}
