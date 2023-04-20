package com.thankryu.trip.service;


import com.thankryu.trip.dto.CreateMemberRequest;

public interface MemberService {

    void join(CreateMemberRequest memberRequest);
}
