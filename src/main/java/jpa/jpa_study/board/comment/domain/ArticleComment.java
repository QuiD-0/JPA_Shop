package jpa.jpa_study.board.comment.domain;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import jpa.jpa_study.board.article.domain.Article;
import jpa.jpa_study.board.article.domain.BaseFields;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ArticleComment extends BaseFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ToString.Exclude
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
