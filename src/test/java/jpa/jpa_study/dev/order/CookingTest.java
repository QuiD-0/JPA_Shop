package jpa.jpa_study.dev.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CookingTest {

    @Test
    public void cooking() {
        Cooking cooking = new Cooking();
        MenuItem menu = new MenuItem("돈까스", 5000);

        Cook cook = cooking.makeFood(menu);

        Assertions.assertThat(cook.getName()).isEqualTo("돈까스");
    }

}
