package com.thankryu.trip.service;

import com.thankryu.trip.dto.ExchangeRateDto;
import com.thankryu.trip.dto.ExchangeRequestDto;

public interface ExchangeService {

    ExchangeRateDto getExchange(ExchangeRequestDto dto);
}
