package jpa.jpa_study.board.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

public class ArticleComment {

    @Id
    @GeneratedValue
    private Long id;

    private Article article;

    private String title;

    private String content;

    private String hashtag;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime modifiedAt;

    private String modifiedBy;
}
