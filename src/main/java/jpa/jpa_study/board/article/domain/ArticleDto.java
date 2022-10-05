package jpa.jpa_study.board.article.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public record ArticleDto(LocalDateTime createdAt, String createdBy, String title, String content,
                         String hashtag) implements Serializable {

    public static ArticleDto toArticleDto(Article entity) {
        return new ArticleDto(
            entity.getCreatedAt(),
            entity.getCreatedBy(),
            entity.getTitle(),
            entity.getContent(),
            entity.getHashtag()
        );
    }

    public static Article toEntity(ArticleDto dto) {
        return Article.builder().content(dto.content).createdBy(dto.createdBy).hashtag(dto.hashtag)
            .title(dto.title).build();
    }
}
