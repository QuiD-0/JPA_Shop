package jpa.jpa_study.board.domain;

import java.io.Serializable;

public record ArticleDto(String title, String content, String hashtag) implements Serializable {

}
