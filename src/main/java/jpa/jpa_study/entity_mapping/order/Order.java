package jpa.jpa_study.entity_mapping.order;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

//@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @Column(name = "member_id")
    private Long memberId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Enumerated(EnumType.STRING)
    private OrderState status;
}
