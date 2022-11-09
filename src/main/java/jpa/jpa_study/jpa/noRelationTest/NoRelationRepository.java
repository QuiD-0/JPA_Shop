package jpa.jpa_study.jpa.noRelationTest;

import static jpa.jpa_study.jpa.noRelationTest.QSchool.school;
import static jpa.jpa_study.jpa.noRelationTest.QStudent.student;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class NoRelationRepository {

    private final JPAQueryFactory queryFactory;

    public List<StudentWithSchoolDto> findSchool() {
        return queryFactory.select(
                Projections.constructor(StudentWithSchoolDto.class, student.schoolId, student.name,
                    school.name)).from(student)
            .join(school)
            .on(school.schoolId.eq(student.schoolId))
            .fetch();
    }
}
