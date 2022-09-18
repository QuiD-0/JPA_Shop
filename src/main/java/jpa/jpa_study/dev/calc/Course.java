package jpa.jpa_study.dev.calc;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Course {

    private String name;

    private int credit;

    private Grades grade;

    @Builder
    public Course(String name, int credit, Grades grade) {
        this.name = name;
        this.credit = credit;
        this.grade = grade;
    }

    public double getCreditMulGrade(){
        return credit * grade.getPoint();
    }
}
