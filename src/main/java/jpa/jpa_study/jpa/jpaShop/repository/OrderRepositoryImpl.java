package jpa.jpa_study.jpa.jpaShop.repository;

import jpa.jpa_study.jpa.jpaShop.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

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

//    public List<Order> findAll(){
//
//    }
}
