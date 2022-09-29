package jpa.jpa_study.board.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import org.springframework.data.auditing.config.AuditingConfiguration;

@Entity
@Getter
@ToString
@EntityListeners(AuditingConfiguration.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ArticleComment {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = false)
    private Article article;

    @Column(nullable = false, length = 500)
    private String content;

    private String hashtag;

    @CreatedDate
    private LocalDateTime createdAt;

    @CreatedBy
    @Column(nullable = false, length = 100)
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime modifiedAt;

    @LastModifiedBy
    @Column(nullable = false, length = 100)
    private String modifiedBy;

    @Builder
    public ArticleComment(Article article, String content, String hashtag) {
        this.article = article;
        this.content = content;
        this.hashtag = hashtag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ArticleComment))
            return false;
        ArticleComment that = (ArticleComment) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
