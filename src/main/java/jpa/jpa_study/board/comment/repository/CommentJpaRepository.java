package jpa.jpa_study.board.comment.repository;

import jpa.jpa_study.board.comment.domain.ArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CommentJpaRepository extends JpaRepository<ArticleComment,Long> {

}
