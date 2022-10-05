package jpa.jpa_study.board.article.service;

import jpa.jpa_study.board.article.domain.ArticleDto;
import jpa.jpa_study.board.article.domain.SearchType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArticleService {

    Page<ArticleDto> searchArticlesPage(SearchType searchType, String key, Pageable pageable);

}
