package jpa.jpa_study.jpa.noRelationTest;

import lombok.Builder;
import lombok.Data;

@Data
public class StudentWithSchoolDto {

    private Long studentId;

    private String name;

    private String schoolName;

    @Builder
    public StudentWithSchoolDto(Long studentId, String name, String schoolName) {
        this.studentId = studentId;
        this.name = name;
        this.schoolName = schoolName;
    }
}
