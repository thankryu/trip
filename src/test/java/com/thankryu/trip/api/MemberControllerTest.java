package com.thankryu.trip.api;

import com.thankryu.trip.dto.CreateMemberRequest;
import com.thankryu.trip.repository.MemberRepository;
import com.thankryu.trip.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class MemberControllerTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    /**
     * 회원가입 테스트
     * @throws Exception
     */
    @Test
    public void memberJoin() throws Exception{

        CreateMemberRequest memberRequest = new CreateMemberRequest();

        memberRequest.setName("유경한");
        memberRequest.setEmail("thankryu@gmail.com");
        memberRequest.setPhone_number("010-6507-6087");

        Long id = memberService.join(memberRequest);

        assertThat(memberRequest.getName()).isEqualTo(memberRepository.findById(id).get().getName());
        assertThat(memberRequest.getEmail()).isEqualTo(memberRepository.findById(id).get().getEmail());
        assertThat(memberRequest.getPhone_number()).isEqualTo(memberRepository.findById(id).get().getPhone_number());

    }
}