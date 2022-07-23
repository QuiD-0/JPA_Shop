package jpa.jpa_study.jpa.advanced_mapping.member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Setter
@Getter
@ToString
public class BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    
}
