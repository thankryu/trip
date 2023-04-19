package com.thankryu.trip.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thankryu.trip.entity.item.ItemEntity;
import lombok.Getter;

import javax.persistence.*;

/**
 * 판매상품 entity
 */
@Entity
@Getter
public class OrderItemEntity {

    @Id
    @GeneratedValue
    @Column(name="order_item_id")
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id")
    private OrderEntity order; // 주문 목록

    private int orderPrice; // 가격
    private int count; // 갯수

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="item_id")
    private ItemEntity item; // 아이템
}
