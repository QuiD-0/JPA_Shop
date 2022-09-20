package jpa.jpa_study.dev.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MenuItemTest {

    @Test
    public void create() {
        Assertions.assertThatCode(() -> new MenuItem("김밥", 2000)).doesNotThrowAnyException();
    }

}
