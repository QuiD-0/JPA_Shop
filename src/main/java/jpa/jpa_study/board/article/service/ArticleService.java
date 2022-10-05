package jpa.jpa_study.board.article.service;

import java.util.List;
import jpa.jpa_study.board.article.domain.ArticleDto;
import jpa.jpa_study.board.article.domain.SearchType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArticleService {

    List<ArticleDto> searchArticlesList(SearchType searchType, String key);

    Page<ArticleDto> searchArticlesPage(SearchType searchType, String key, Pageable pageable);

}
