package jpa.jpa_study.board.comment.domain;

import java.io.Serializable;

public record ArticleCommentDto(Long articleId, String content) implements Serializable {

}
