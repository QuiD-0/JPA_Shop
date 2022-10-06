package jpa.jpa_study.board.comment.controller;

import jpa.jpa_study.board.comment.domain.ArticleCommentDto;
import jpa.jpa_study.board.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public void saveComment(@RequestBody ArticleCommentDto commentDto) {
        commentService.save(commentDto);
    }

}
