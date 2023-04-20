package com.thankryu.trip.entity.item;

import lombok.Getter;

import javax.persistence.*;

/**
 * 상품 entity
 */
@Entity
@Getter
@Table(name="ITEM_TB")
public abstract class ItemEntity {

    @Id
    @GeneratedValue
    @Column(name="item_id")
    private Long id;

    private String name; // 상품 이름
    private int price; // 가격
    private int stockQuantity; // 재고
}
