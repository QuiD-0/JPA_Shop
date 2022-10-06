package jpa.jpa_study.board.user.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Builder;

@Builder
public record UserDto(LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt,
                      String userId, String userPassword, String email, String nickname,
                      String memo) implements
    Serializable {

    public static UserDto fromUser(User user) {
        return UserDto.builder()
            .userId(user.getUserId())
            .userPassword(user.getUserPassword())
            .email(user.getEmail())
            .nickname(user.getNickname())
            .createdBy(user.getCreatedBy())
            .build();
    }
}
