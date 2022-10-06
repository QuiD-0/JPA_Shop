package jpa.jpa_study.board.comment.service;

import jpa.jpa_study.board.comment.domain.ArticleCommentDto;

public interface CommentService {

    void save(ArticleCommentDto dto);
}
