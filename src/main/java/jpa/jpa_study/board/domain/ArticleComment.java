package jpa.jpa_study.board.domain;

import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Getter
@ToString
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

  @CreationTimestamp
  private LocalDateTime createdAt;

  private String createdBy;

  @UpdateTimestamp
  private LocalDateTime modifiedAt;

  @Builder
  public ArticleComment(Article article, String content, String hashtag, String createdBy) {
    this.article = article;
    this.content = content;
    this.hashtag = hashtag;
    this.createdBy = createdBy;
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
