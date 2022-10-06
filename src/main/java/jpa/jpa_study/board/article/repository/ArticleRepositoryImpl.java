package jpa.jpa_study.board.article.repository;

import static jpa.jpa_study.board.article.domain.QArticle.article;

import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.Optional;
import jpa.jpa_study.board.article.domain.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ArticleRepositoryImpl implements ArticleRepository {

    private final ArticleRestRepository articleRestRepository;

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<String> findAllHashtag() {
        return jpaQueryFactory.select(article.hashtag).from(article).distinct()
            .where(article.hashtag.isNotNull()).fetch();
    }


    @Override
    public Page<Article> findByTitleContaining(String title, Pageable pageable) {
        return articleRestRepository.findByTitleContaining(title, pageable);
    }

    @Override
    public Page<Article> findByContentContaining(String key, Pageable pageable) {
        return articleRestRepository.findByContentContaining(key, pageable);
    }

    @Override
    public Page<Article> findByHashtag(String key, Pageable pageable) {
        return articleRestRepository.findByHashtag(key, pageable);
    }

    @Override
    public Optional<Article> findById(Long id) {
        return articleRestRepository.findById(id);
    }

    @Override
    public Page<Article> findAll(Pageable pageable) {
        return articleRestRepository.findAll(pageable);
    }

    @Override
    public List<Article> findSearchtag(String key) {
        return jpaQueryFactory.selectFrom(article).where(article.hashtag.contains(key)).distinct()
            .fetch();
    }
}
