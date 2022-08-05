package jpa.jpa_study.jpa.jpaShop.repository;

import jpa.jpa_study.jpa.jpaShop.domain.Order;
import jpa.jpa_study.jpa.jpaShop.domain.OrderSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository{
    private final EntityManager em;

    @Override
    public void save(Order order){
        em.persist(order);
    }

    @Override
    public Order findOne(Long id){
        return em.find(Order.class,id);
    }

    @Override
    public List<Order> findOrders(OrderSearch orderSearch) {
        return null;
    }

}