package jpa.jpa_study.board.article.repository;

import java.util.Optional;
import jpa.jpa_study.board.article.domain.Article;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class JpaTest {

    @Autowired
    ArticleRestRepository articleRestRepository;

    @Test
    void select_test() {
        Assertions.assertThatCode(() -> articleRestRepository.findAll()).doesNotThrowAnyException();
    }

    @Test
    void insert_test() {
        Article article = Article.builder().title("test").content("test contents").hashtag("#jpa").build();
        Assertions.assertThatCode(() -> articleRestRepository.save(article))
            .doesNotThrowAnyException();
    }

    @Test
    void delete_test() {
        Article article = Article.builder().title("test").content("test contents").hashtag("#jpa")
            .build();
        articleRestRepository.save(article);
        Assertions.assertThatCode(() -> articleRestRepository.delete(article))
            .doesNotThrowAnyException();
    }

    @Test
    void update_test() {
        Article article = Article.builder().title("test").content("test contents").hashtag("#jpa").build();
        articleRestRepository.save(article);
        article.updateContents("update");
        org.junit.jupiter.api.Assertions.assertEquals(article.getContent(), "update");
    }

    @Test
    public void timestampTest() {
        Article article = Article.builder().title("test").content("test").build();
        articleRestRepository.save(article);

        Optional<Article> found = articleRestRepository.findById(article.getId());
        System.out.println(found.get().getCreatedAt());

    }
}