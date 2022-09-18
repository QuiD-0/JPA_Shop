package jpa.jpa_study.dev.valid;

import lombok.Getter;

@Getter
public class User {

    private String password;

    public void initPassword(String password) {
        PasswordValidator.validate(password);
        this.password = password;
    }

}
