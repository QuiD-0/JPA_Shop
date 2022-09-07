package jpa.jpa_study.jpa.jpaShop.api;

import jpa.jpa_study.jpa.jpaShop.domain.Order;
import jpa.jpa_study.jpa.jpaShop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderApiController {

    private final OrderService orderService;

    @GetMapping("/api/v1/orders")
    public List<Order> ordersV1() {
        return orderService.findOrders();
    }

    @GetMapping("/api/v2/orders")
    public List<Order> ordersV2() {
        return orderService.findOrdersWithItem();
    }

}
