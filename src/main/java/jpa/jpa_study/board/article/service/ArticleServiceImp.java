package jpa.jpa_study.board.article.service;


import java.util.List;
import javax.ws.rs.NotFoundException;
import jpa.jpa_study.board.article.domain.ArticleDto;
import jpa.jpa_study.board.article.domain.SearchType;
import jpa.jpa_study.board.article.repository.ArticleRepository;
import jpa.jpa_study.board.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArticleServiceImp implements ArticleService {

    private final ArticleRepository articleRepository;

    private final UserRepository userRepository;

    @Override
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

    @Override
    public List<String> findAllHashtag() {
        return articleRepository.findAllHashtag();
    }

    @Override
    public List<ArticleDto> searchHashtag(String key) {
        return articleRepository.findSearchtag(key).stream().map(ArticleDto::toArticleDto).toList();
    }

    @Override
    public ArticleDto getArticle(Long id, String name) {
        userRepository.findById(name).orElseThrow(NotFoundException::new);
        return articleRepository.findById(id).map(ArticleDto::toArticleDto)
            .orElseThrow(() -> new NotFoundException());
    }
}
