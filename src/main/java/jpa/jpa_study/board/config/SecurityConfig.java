package jpa.jpa_study.board.config;

import javax.ws.rs.NotFoundException;
import jpa.jpa_study.board.user.domain.BoardPrincipal;
import jpa.jpa_study.board.user.domain.UserDto;
import jpa.jpa_study.board.user.repository.UserRepository;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(auth -> auth.mvcMatchers(
                HttpMethod.GET, "/", "/articles").permitAll().anyRequest().authenticated())
            .formLogin().and()
            .csrf().disable()
            .logout().logoutSuccessUrl("/").and()
            .build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web -> web.ignoring()
            .requestMatchers(PathRequest.toStaticResources().atCommonLocations()));
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return username -> userRepository.findById(username)
            .map(UserDto::fromUser)
            .map(BoardPrincipal::toPrincipal)
            .orElseThrow(NotFoundException::new);
    }

    @Bean
    public PasswordEncoder noOpPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
