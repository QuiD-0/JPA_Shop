package jpa.jpa_study.dev.calc;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CourseTest {

    @Test
    @DisplayName("테스트 과목 생성")
    void create() {
        Assertions.assertThatCode(()-> new Course("OOP",3,Grades.AP)).doesNotThrowAnyException();
    }

    @Test
    void createCalc() {
        List<Course> courses = List.of(new Course("OOP", 3, Grades.AP), new Course("JAVA", 3, Grades.AP));

        GradeCalc gradeCalc = new GradeCalc(courses);
        double result = gradeCalc.calculate();

        Assertions.assertThat(result).isEqualTo(4.5);
    }
}

