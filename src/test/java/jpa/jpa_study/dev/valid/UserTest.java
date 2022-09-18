package jpa.jpa_study.dev.valid;

import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    public void test(){
        User user = new User();
        user.initPassword("testPassa");
    }
}