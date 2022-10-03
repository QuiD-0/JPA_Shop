package jpa.jpa_study.board.domain;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(indexes = {@Index(columnList = "title"), @Index(columnList = "hashtag"),
    @Index(columnList = "createdAt")})
public class Article extends BaseFields{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false, length = 10000)
  private String content;

  private String hashtag;


  @ToString.Exclude
  @OrderBy("id")
  @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
  private Set<ArticleComment> articleComment = new LinkedHashSet<>();

  @Builder
  public Article(String title, String content, String hashtag, String createdBy) {
    super(createdBy);
    this.title = title;
    this.content = content;
    this.hashtag = hashtag;
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
