package jpa.jpa_study.dev.calc;

import java.util.List;

public class GradeCalc {

    private final List<Course> courseList;

    public GradeCalc(List<Course> courseList) {
        this.courseList = courseList;
    }

    public double calculate() {
        return this.courseList.stream().mapToDouble(i -> i.getCreditMulGrade()).sum() / this.courseList.stream().mapToInt(i -> i.getCredit()).sum();
    }
}
