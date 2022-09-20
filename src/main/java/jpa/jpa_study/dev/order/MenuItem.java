package jpa.jpa_study.dev.order;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MenuItem {

    private String name;

    private int price;

    public boolean matches(String name) {
        return this.name.equals(name);
    }
}
