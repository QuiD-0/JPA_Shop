package jpa.jpa_study.board.article.service;

import javax.ws.rs.NotFoundException;
import jpa.jpa_study.board.article.domain.ArticleDto;
import jpa.jpa_study.board.article.domain.SearchType;
import jpa.jpa_study.board.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ArticleServiceImp implements ArticleService {

    private final ArticleRepository articleRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<ArticleDto> searchArticlesPage(SearchType searchType, String key,
        Pageable pageable) {
        if (key == null || key.isBlank()) {
            return articleRepository.findAll(pageable).map(ArticleDto::toArticleDto);
        }
        return switch (searchType) {
            case TITLE -> articleRepository.findByTitleContaining(key, pageable)
                .map(ArticleDto::toArticleDto);
            case CONTENT -> articleRepository.findByContentContaining(key, pageable)
                .map(ArticleDto::toArticleDto);
            case HASHTAG ->
                articleRepository.findByHashtag(key, pageable).map(ArticleDto::toArticleDto);
            default -> throw new IllegalStateException("Unexpected value: " + searchType);
        };
    }

    @Transactional(readOnly = true)
    public ArticleDto getArticle(Long id) {
        return articleRepository.findById(id).map(ArticleDto::toArticleDto)
            .orElseThrow(() -> new NotFoundException());
    }
}
