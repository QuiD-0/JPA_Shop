package jpa.jpa_study.board.repository;

import jpa.jpa_study.board.config.JpaConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@DisplayName("JPA 연결 테스트")
@Import(JpaConfig.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class JpaTest {

    @Autowired
    ArticleRepository articleRepository;

    @Test
    @DisplayName("select 테스트")
    void testCode() {
        Assertions.assertThatCode(()-> articleRepository.findAll()).doesNotThrowAnyException();

    }

}