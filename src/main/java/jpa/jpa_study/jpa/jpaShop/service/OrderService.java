package jpa.jpa_study.jpa.jpaShop.service;

import jpa.jpa_study.jpa.jpaShop.api.dto.OrderDto;
import jpa.jpa_study.jpa.jpaShop.api.dto.QueryDto;
import jpa.jpa_study.jpa.jpaShop.domain.*;
import jpa.jpa_study.jpa.jpaShop.domain.item.Item;
import jpa.jpa_study.jpa.jpaShop.repository.ItemRepository;
import jpa.jpa_study.jpa.jpaShop.repository.MemberRepository;
import jpa.jpa_study.jpa.jpaShop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final MemberRepository memberRepository;

    private final OrderRepository orderRepository;

    private final ItemRepository itemRepository;

    @Transactional
    public Long order(Long member_id, Long item_id, int count) {
        Member member = memberRepository.findOne(member_id);
        Item item = itemRepository.findOne(item_id);

        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());

        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

        Order order = Order.createOrder(member, delivery, orderItem);

        orderRepository.save(order);

        return order.getId();
    }

    @Transactional
    public void cancel(Long id) {
        Order order = orderRepository.findOne(id);
        order.cancel();
    }

    @Transactional(readOnly = true)
    public List<Order> findOrders(OrderSearch orderSearch) {
        return orderRepository.findOrders(orderSearch);
    }

    @Transactional
    public List<Order> findOrdersWithItem() {
        return orderRepository.findAllWithItem();
    }

    @Transactional(readOnly = true)
    public List<Order> findOrders() {
        return orderRepository.findOrders();
    }

    @Transactional(readOnly = true)
    public List<OrderDto> findOrdersPaging() {
        return orderRepository.findAllWithItem().stream().map(Order::convertToOrderDto).collect(Collectors.toList());
    }

}
