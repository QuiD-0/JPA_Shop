package jpa.jpa_study.jpa.jpaShop.repository;

import jpa.jpa_study.jpa.jpaShop.domain.item.Item;

import java.util.List;

public interface ItemRepository {

    void save(Item item);

    Item findOne(Long id);

    List<Item> findAll();
}
