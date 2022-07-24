package jpa.jpa_study.jpa.jpaShop.service;

import jpa.jpa_study.jpa.jpaShop.domain.item.Item;

import java.util.List;

public interface ItemService {

    void saveItem(Item item);
    List<Item> findItems();
    Item findOne(Long id);

}
