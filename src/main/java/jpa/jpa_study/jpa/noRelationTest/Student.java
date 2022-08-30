package jpa.jpa_study.jpa.noRelationTest;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Student {

    @Id
    @GeneratedValue
    @Column(name = "student_id")
    private Long id;

    private String name;

}
