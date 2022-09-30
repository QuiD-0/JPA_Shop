package jpa.jpa_study.board.domain;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
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
@Table(indexes = {@Index(columnList = "title"), @Index(columnList = "hashtag"),
    @Index(columnList = "createdAt")})
public class Article {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false, length = 10000)
  private String content;

  private String hashtag;

  @CreationTimestamp
  private LocalDateTime createdAt;

  private String createdBy;

  @UpdateTimestamp
  private LocalDateTime modifiedAt;


  @ToString.Exclude
  @OrderBy("id")
  @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
  private Set<ArticleComment> articleComment = new LinkedHashSet<>();

  @Builder
  public Article(String title, String content, String hashtag, String createdBy) {
    this.title = title;
    this.content = content;
    this.hashtag = hashtag;
    this.createdBy = createdBy;
  }

  @Override
  public boolean equals(Object o) {
      if (this == o) {
          return true;
      }
      if (!(o instanceof Article)) {
          return false;
      }
    Article article = (Article) o;
    return id.equals(article.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  public void updateContents(String update) {
    this.content = update;
  }
}
