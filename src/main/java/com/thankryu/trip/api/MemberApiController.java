package com.thankryu.trip.api;

import com.thankryu.trip.dto.CreateMemberRequest;
import com.thankryu.trip.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
@Slf4j
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    /**
     * 회원 가입
     * @param memberRequest
     * @return
     */
    @GetMapping("/join")
    public Result joinMember(@RequestBody CreateMemberRequest memberRequest){

        // 로직 진행
        Long id = memberService.join(memberRequest);

        // 결과 반환
        return new Result(id);
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T data;
    }


}

