package jpa.jpa_study.advanced_mapping.member;

import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Setter
public class BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    
}
