package jpa.jpa_study.board.article.repository;

import java.util.List;
import java.util.Optional;
import jpa.jpa_study.board.article.domain.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArticleRepository {

    List<String> findAllHashtag();

    Page<Article> findByTitleContaining(String title, Pageable pageable);

    Page<Article> findByContentContaining(String key, Pageable pageable);

    Page<Article> findByHashtag(String key, Pageable pageable);

    Optional<Article> findById(Long id);

    Page<Article> findAll(Pageable pageable);

    List<Article> findSearchtag(String key);
}
