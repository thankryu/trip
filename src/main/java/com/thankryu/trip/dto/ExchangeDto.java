package com.thankryu.trip.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ExchangeDto {
    String searchdate;
    String data;
    String authkey;

    @Builder
    public ExchangeDto(String searchdate, String data, String authkey) {
        this.searchdate = searchdate;
        this.data = data;
        this.authkey = authkey;
    }
}