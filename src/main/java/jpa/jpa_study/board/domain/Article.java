package jpa.jpa_study.board.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

public class Article {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String hashtag;

    private ArticleComment comments;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime modifiedAt;

    private String modifiedBy;

}
