package jpa.jpa_study.jpa.jpaShop.repository;

import jpa.jpa_study.jpa.jpaShop.domain.Order;

public interface OrderRepository {
    void save(Order order);

    Order findOne(Long id);
}
