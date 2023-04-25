package com.thankryu.trip.service;

import com.thankryu.trip.dto.CreateMemberRequest;
import com.thankryu.trip.entity.MemberEntity;
import com.thankryu.trip.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Transactional
    @Override
    public Long join(CreateMemberRequest memberRequest) {

        MemberEntity member = MemberEntity.builder()
                .phone_number(memberRequest.getPhone_number())
                .email(memberRequest.getEmail())
                .name(memberRequest.getName())
                .build();

        memberRepository.save(member);
        return member.getId();
    }
}