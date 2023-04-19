package com.thankryu.trip.entity.item;

import com.thankryu.trip.enums.CurrencyType;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * 예약 아이템 entity
 */
@Entity
@Getter
public class ReservationEntity extends ItemEntity{

    private String name; // 이름

    private String country; // 국가

    @Enumerated(EnumType.STRING)
    private CurrencyType currency; // 통화

    private String location; // 위치
}
