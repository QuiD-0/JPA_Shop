package jpa.jpa_study.board.user.domain;

import java.util.Collection;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Builder
public record BoardPrincipal(String username, String password,
                             Collection<? extends GrantedAuthority> authorities, String email,
                             String nickname, String memo) implements
    UserDetails {

    public static BoardPrincipal toPrincipal(UserDto userDto) {
        return BoardPrincipal.builder().username(userDto.userId()).password(userDto.userPassword())
            .email(userDto.email())
            .nickname(userDto.nickname()).memo(userDto.memo()).build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
