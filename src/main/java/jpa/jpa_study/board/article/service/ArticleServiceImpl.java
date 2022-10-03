package jpa.jpa_study.board.article.service;

import jpa.jpa_study.board.article.domain.Article;
import jpa.jpa_study.board.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Override
    public List<Article> getArticle() {
        return articleRepository.findAll();
    }
}
