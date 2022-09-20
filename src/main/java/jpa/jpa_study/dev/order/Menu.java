package jpa.jpa_study.dev.order;

import java.util.List;

public class Menu {

    private List<MenuItem> menu;

    public Menu(List<MenuItem> menu) {
        this.menu = menu;
    }

    public MenuItem choose(String name) {
        return this.menu.stream().filter(menuItem -> menuItem.matches(name)).findFirst().orElseThrow(() -> new IllegalArgumentException());
    }

}
