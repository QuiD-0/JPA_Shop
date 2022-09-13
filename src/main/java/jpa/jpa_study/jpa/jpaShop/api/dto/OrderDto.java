package jpa.jpa_study.jpa.jpaShop.api.dto;

import jpa.jpa_study.jpa.jpaShop.domain.Delivery;
import jpa.jpa_study.jpa.jpaShop.domain.Member;
import jpa.jpa_study.jpa.jpaShop.domain.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class OrderDto {
    private Member member;

    private List<OrderItem> orderItems = new ArrayList<>();

    private Delivery delivery;

    private LocalDateTime orderDate;

    @Builder
    public OrderDto(Member member, List<OrderItem> orderItems, Delivery delivery, LocalDateTime orderDate) {
        this.member = member;
        this.orderItems = orderItems;
        this.delivery = delivery;
        this.orderDate = orderDate;
    }
}
