package jpa.jpa_study.dev.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CustomerTest {

    /**
     * 손님 - 메뉴
     * 손님 - 요리사
     * 요리사 - 요리
     * <p>
     * 손님, 요리, 메뉴판, 메뉴,
     */

    @Test
    public void order_when_exist() {
        Customer customer = new Customer();
        Menu menu = new Menu(List.of(new MenuItem("돈까스", 5000), new MenuItem("라면", 3000)));
        Cooking cooking = new Cooking();

        Assertions.assertThatCode(()-> customer.order("라면", menu, cooking)).doesNotThrowAnyException();
    }

    @Test
    public void order_when_not_exist() {
        Customer customer = new Customer();
        Menu menu = new Menu(List.of(new MenuItem("돈까스", 5000), new MenuItem("라면", 3000)));
        Cooking cooking = new Cooking();

        Assertions.assertThatCode(()-> customer.order("김밥", menu, cooking)).isInstanceOf(IllegalArgumentException.class);
    }

}
