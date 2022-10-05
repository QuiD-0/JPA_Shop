package jpa.jpa_study.board.user.repository;

import jpa.jpa_study.board.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
