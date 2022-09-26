package jpa.jpa_study.board.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(indexes = {@Index(columnList = "title"), @Index(columnList = "hashtag"), @Index(columnList = "createdAt"), @Index(columnList = "createdBy")})
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 10000)
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
    public Article(String title, String content, String hashtag) {
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Article))
            return false;
        Article article = (Article) o;
        return id.equals(article.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
