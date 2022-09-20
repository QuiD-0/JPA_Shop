package jpa.jpa_study.dev.order;

public class Cooking {

    public Cook makeFood(MenuItem menu) {
        return new Cook(menu.getName(), menu.getPrice());
    }
}
