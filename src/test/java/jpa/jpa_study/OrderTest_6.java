package jpa.jpa_study;

import jpa.jpa_study.jpa.various_relation_mapping.order.Item;
import jpa.jpa_study.jpa.various_relation_mapping.order.Member;
import jpa.jpa_study.jpa.various_relation_mapping.order.Order;
import jpa.jpa_study.jpa.various_relation_mapping.order.OrderItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
public class OrderTest_6 {

    @Autowired
    private EntityManager em;

    @Test
    @Transactional
    public void orderTest(){
        Member member = creatMember();
        em.persist(member);
        Item item = creatItem();
        em.persist(item);
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        Order order = new Order();
        orderItem.setOrder(order);
        order.setMember(member);
        order.addOrderItem(orderItem);
        em.persist(order);
        em.persist(orderItem);
        em.flush();
        em.clear();
        Order order1 = em.find(Order.class, order.getId());
        System.out.println(order1.getMember());
    }

    private Item creatItem() {
        Item item = new Item();
        item.setName("상품1");
        item.setPrice(10000);
        item.setStockQuantity(10);
        return item;
    }

    private Member creatMember() {
        Member member = new Member();
        member.setName("회원1");
        member.setCity("서울");
        member.setStreet("을지로 3가");
        member.setZipcode("12312");
        return member;
    }

}
