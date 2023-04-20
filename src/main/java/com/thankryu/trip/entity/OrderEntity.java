package com.thankryu.trip.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name="ORDER_TB")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private MemberEntity member; // 회원

    @Column(name = "order_name")
    private String orderName; // 주문명

    @Column
    private String orderStDate; // 시작일

    @Column
    private String orderEdDate; // 종료일

    @Column
    private int orderPrice; // 가격

    @Column
    private int count; // 주문 갯수

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItemEntity> orderItems = new ArrayList<>(); // 판매상품
}
