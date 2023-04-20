package com.thankryu.trip.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class CreateMemberRequest {

    @NotEmpty
    private String name;

    private String email;

    private String phone_number;

    private String type;
}
