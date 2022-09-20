package jpa.jpa_study.dev.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MenuTest {

    @Test
    public void chooseTest() {
        Menu menu = new Menu(List.of(new MenuItem("돈까스", 5000), new MenuItem("라면", 3000)));

        MenuItem menuItem = menu.choose("라면");

        Assertions.assertThat(menuItem.getName()).isEqualTo("라면");
    }

}
