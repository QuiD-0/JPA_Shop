package jpa.jpa_study.board.user.domain;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import jpa.jpa_study.board.article.domain.BaseFields;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseFields {

    @Id
    @Column(length = 50)
    private String userId;

    @Column(nullable = false)
    private String userPassword;

    private String email;

    private String nickname;

    private String memo;

    @Builder
    public User(String createdBy, String userId, String userPassword, String email, String nickname,
        String memo) {
        super(createdBy);
        this.userId = userId;
        this.userPassword = userPassword;
        this.email = email;
        this.nickname = nickname;
        this.memo = memo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User user)) {
            return false;
        }
        return this.getUserId() != null && this.getUserId().equals(user.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
