package jpa.jpa_study.board.article.controller;

import java.util.List;
import jpa.jpa_study.board.article.domain.ArticleDto;
import jpa.jpa_study.board.article.domain.SearchType;
import jpa.jpa_study.board.article.service.ArticleService;
import jpa.jpa_study.board.user.domain.BoardPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping
    public Page<ArticleDto> articles(@RequestParam(required = false) SearchType searchType,
        @RequestParam(required = false) String searchValue,
        @PageableDefault(direction = Direction.DESC) Pageable pageable) {
        return articleService.searchArticlesPage(searchType, searchValue, pageable);
    }

    @GetMapping("/{id}")
    public ArticleDto findOne(@PathVariable String id, @AuthenticationPrincipal BoardPrincipal boardPrincipal) {
        return articleService.getArticle(Long.valueOf(id),boardPrincipal.getUsername());
    }

    @GetMapping("/hashtag")
    public List<String> hashtags() {
        return articleService.findAllHashtag();
    }

    @GetMapping("/hashtag/{key}")
    public List<ArticleDto> hashtags(@PathVariable String key) {
        return articleService.searchHashtag(key);
    }
}
