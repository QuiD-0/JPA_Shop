package jpa.jpa_study.board.article.service;

import java.util.List;
import jpa.jpa_study.board.article.domain.ArticleDto;
import jpa.jpa_study.board.article.domain.SearchType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

public interface ArticleService {

    Page<ArticleDto> searchArticlesPage(SearchType searchType, String key, Pageable pageable);

    List<String> findAllHashtag();

    List<ArticleDto> searchHashtag(String key);

    @Transactional(readOnly = true)
    ArticleDto getArticle(Long id, String name);
}
