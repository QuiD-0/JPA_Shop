package jpa.jpa_study.board.article.domain;

public enum SearchType {
    TITLE("제목"), CONTENT("본문"), HASHTAG("해시태그");

    private final String description;

    SearchType(String description) {
        this.description = description;
    }
}
