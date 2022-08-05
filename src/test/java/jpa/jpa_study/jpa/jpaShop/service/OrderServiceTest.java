package jpa.jpa_study.jpa.jpaShop.service;

import jpa.jpa_study.jpa.jpaShop.domain.Member;
import jpa.jpa_study.jpa.jpaShop.domain.Order;
import jpa.jpa_study.jpa.jpaShop.domain.OrderStatus;
import jpa.jpa_study.jpa.jpaShop.domain.item.Book;
import jpa.jpa_study.jpa.jpaShop.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
@Transactional
class OrderServiceTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRepository;

    @Test
    public void 상품_주문(){
        Member member = new Member();
        member.setName("asd");
        em.persist(member);
        Book book = new Book();
        book.setName("testBook");
        book.setPrice(10000);
        book.setStockQuantity(10);
        em.persist(book);

        int orderCount = 2;

        Long orderId = orderService.order(member.getId(),book.getId(),orderCount);

        Order getOrder = orderRepository.findOne(orderId);

        assertEquals("주문상태는 ORDER", OrderStatus.ORDER,getOrder.getOrderStatus());
    }
}