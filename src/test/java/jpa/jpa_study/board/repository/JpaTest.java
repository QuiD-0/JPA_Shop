package jpa.jpa_study.board.repository;

import jpa.jpa_study.board.domain.Article;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class JpaTest {

    @Autowired
    ArticleRepository articleRepository;

    @Test
    void select_test() {
        Assertions.assertThatCode(() -> articleRepository.findAll()).doesNotThrowAnyException();
    }

    @Test
    void insert_test() {
        Article article = Article.builder().title("test").content("test contents").hashtag("#jpa").build();
        Assertions.assertThatCode(() -> articleRepository.save(article)).doesNotThrowAnyException();
    }

    @Test
    void delete_test() {
        Article article = Article.builder().title("test").content("test contents").hashtag("#jpa").build();
        articleRepository.save(article);
        Assertions.assertThatCode(() -> articleRepository.delete(article)).doesNotThrowAnyException();
    }

    @Test
    void update_test() {
        Article article = Article.builder().title("test").content("test contents").hashtag("#jpa").build();
        articleRepository.save(article);
        article.updateContents("update");
        org.junit.jupiter.api.Assertions.assertEquals(article.getContent(), "update");
    }

    @Test
    public void timestampTest(){
        Article article = Article.builder().title("test").content("test").build();
        articleRepository.save(article);

        Optional<Article> found = articleRepository.findById(article.getId());
        System.out.println(found.get().getCreatedAt());

    }
}