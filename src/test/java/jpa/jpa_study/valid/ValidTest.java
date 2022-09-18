package jpa.jpa_study.valid;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidTest {

    @Test
    @DisplayName("비밀번호가 8자에서 12자 사이")
    void validator_test(){
        Assertions.assertThatCode(()-> PasswordValidator.validate("testPassword")).doesNotThrowAnyException();
    }

}
