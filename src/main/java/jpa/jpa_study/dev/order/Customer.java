package jpa.jpa_study.dev.order;

public class Customer {

    public void order(String menuName, Menu menu, Cooking cooking){
        MenuItem menuItem = menu.choose(menuName);
        Cook cook = cooking.makeFood(menuItem);
    }

}
