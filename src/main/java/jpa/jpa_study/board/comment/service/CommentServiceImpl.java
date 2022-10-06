package jpa.jpa_study.board.comment.service;

import javax.ws.rs.NotFoundException;
import jpa.jpa_study.board.article.domain.Article;
import jpa.jpa_study.board.article.repository.ArticleRepository;
import jpa.jpa_study.board.comment.domain.ArticleComment;
import jpa.jpa_study.board.comment.domain.ArticleCommentDto;
import jpa.jpa_study.board.comment.repository.CommentRestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final ArticleRepository articleRepository;

    private final CommentRestRepository commentRestRepository;

    @Override
    public void save(ArticleCommentDto dto) {
        Article article = articleRepository.findById(dto.articleId())
            .orElseThrow(NotFoundException::new);

        ArticleComment articleComment = ArticleComment.builder()
            .article(article).content(dto.content()).build();
        commentRestRepository.save(articleComment);

    }

}
