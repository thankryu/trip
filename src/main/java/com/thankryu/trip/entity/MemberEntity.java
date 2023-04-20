package com.thankryu.trip.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thankryu.trip.enums.JoinStatus;
import com.thankryu.trip.enums.JoinType;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 회원 entity
 */
@Entity
@Getter
@Table(name="MEMBER_TB")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private Long id;

    private String name; // 회원 이름

    private String email; // 회원 이메일

    @Enumerated(EnumType.STRING)
    private JoinType type; // 회원 가입 타입

    private String phone_number; // 전화번호

    private LocalDate joinDate; // 가입일

    @Enumerated(EnumType.STRING)
    private JoinStatus status; // 가입 상태

    @JsonIgnore
    @OneToMany
    private List<OrderEntity> orders = new ArrayList<>(); // 주문

    @Builder
    public MemberEntity(String name, String email, JoinType type, String phone_number) {
        this.name = name;
        this.email = email;
        this.type = type;
        this.phone_number = phone_number;
    }

    public MemberEntity() {

    }
}
