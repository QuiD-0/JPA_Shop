package jpa.jpa_study.board.article.domain;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class ArticleDtoTest {

    @Test
    public void recordTest() {
        ArticleDto articleDto = new ArticleDto(LocalDateTime.now(), "QuiD", "title", "content",
            "#record");
        System.out.println(articleDto);
        System.out.println(articleDto.content());
    }

}