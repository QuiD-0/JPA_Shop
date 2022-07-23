package jpa.jpa_study.jpa.fetchType.order;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//@Entity
@Setter
@Getter
public class OrderItem {
    @Id
    @GeneratedValue
    @Column(name = "ORDERITEM_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    private int orderPrice;

    private int count;

    public void setOrder(Order order){
        if(this.order !=null){
            this.order.getOrderItems().remove(this);
        }
        this.order=order;

    }
}
