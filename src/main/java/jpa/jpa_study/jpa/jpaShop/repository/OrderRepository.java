package jpa.jpa_study.jpa.jpaShop.repository;

import jpa.jpa_study.jpa.jpaShop.domain.Order;
import jpa.jpa_study.jpa.jpaShop.domain.OrderSearch;

import java.util.List;

public interface OrderRepository {
    void save(Order order);

    Order findOne(Long id);

    List<Order> findOrders(OrderSearch orderSearch);
}
