package jpa.jpa_study.board.article.service;

import java.util.List;
import jpa.jpa_study.board.article.domain.ArticleDto;
import jpa.jpa_study.board.article.domain.SearchType;
import jpa.jpa_study.board.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleServiceImp implements ArticleService {

    private final ArticleRepository articleRepository;


    @Override
    public List<ArticleDto> searchArticlesList(SearchType searchType, String key) {
        return articleRepository.findByTitleContainingList(key).stream()
            .map(ArticleDto::toArticleDto)
            .toList();
    }

    @Override
    public Page<ArticleDto> searchArticlesPage(SearchType searchType, String key,
        Pageable pageable) {
        return articleRepository.findByTitleContainingPage(key, pageable)
            .map(ArticleDto::toArticleDto);
    }
}
