package jpa.jpa_study.dev.valid;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidTest {

    @Test
    @DisplayName("비밀번호가 8자에서 12자 사이")
    void validator_test() {
        Assertions.assertThatCode(() -> PasswordValidator.validate("testtestpw")).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("비밀번호가 8자 이하인 경우")
    void valitator_test_when_length_less_then_8() {
        Assertions.assertThatCode(() -> PasswordValidator.validate("test")).isInstanceOf(IllegalArgumentException.class).hasMessage("비밀번호는 최소 8자 최대 12자 이내여야합니다.");
    }

    @Test
    @DisplayName("비밀번호가 12자 이상인 경우")
    void valitator_test_when_length_more_then_12() {
        Assertions.assertThatCode(() -> PasswordValidator.validate("testtesttestr")).isInstanceOf(IllegalArgumentException.class).hasMessage("비밀번호는 최소 8자 최대 12자 이내여야합니다.");
    }
}
