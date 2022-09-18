package jpa.jpa_study.dev.valid;

public class PasswordValidator {

    public static void validate(String pw) {
        int length = pw.length();

        if (length < 8 || length > 12) {
            throw new IllegalArgumentException("비밀번호는 최소 8자 최대 12자 이내여야합니다.");
        }
    }
}
