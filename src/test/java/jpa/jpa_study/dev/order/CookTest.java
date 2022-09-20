package jpa.jpa_study.dev.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CookTest {

    @Test
    public void create(){
        Assertions.assertThatCode(()-> new Cook("만두",6000)).doesNotThrowAnyException();
    }



}
