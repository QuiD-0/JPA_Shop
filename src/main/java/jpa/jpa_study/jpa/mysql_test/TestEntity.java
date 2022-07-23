package jpa.jpa_study.jpa.mysql_test;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class TestEntity {

    @Id
    @GeneratedValue
    @Column(name = "TestEntity_id")
    private Long id;

    private String name;
}
