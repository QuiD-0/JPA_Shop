package jpa.jpa_study.dev.calc;

import lombok.Getter;

@Getter
public enum Grades {
    AP(4.5), A(4), BP(3.5), B(3), CP(2.5), C(2);

    private double point;

    Grades(double point) {
        this.point = point;
    }
}
