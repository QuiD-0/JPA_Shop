package jpa.jpa_study.jpa.noRelationTest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class School {

    @Id
    @GeneratedValue
    @Column(name = "school_id")
    private Long id;

    private String name;

    private int total_students;
}
