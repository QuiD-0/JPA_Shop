package jpa.jpa_study.board.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ArticleComment extends BaseFields {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = false)
    private Article article;

    @Column(nullable = false, length = 500)
    private String content;

    private String hashtag;

    @Builder
    public ArticleComment(Article article, String content, String hashtag, String createdBy) {
        super(createdBy);
        this.article = article;
        this.content = content;
        this.hashtag = hashtag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ArticleComment)) {
            return false;
        }
        ArticleComment that = (ArticleComment) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
