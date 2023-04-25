package com.thankryu.trip.service;

import com.thankryu.trip.dto.ExchangeRateDto;
import com.thankryu.trip.dto.ExchangeRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ExchangeServiceImpl implements ExchangeService{

    // 한국수출입은행 auth key
    @Value("${bank.exchange.authkey}")
    String authkey;

    // 한국수출입은행 API URL
    private String url = "https://www.koreaexim.go.kr/site/program/financial/exchangeJSON";

    /**
     * 환율 조회
     * @param dto
     * @return
     */
    @Override
    public ExchangeRateDto getExchange(ExchangeRequestDto dto) {

        // 수출입은행 API 통신
        // 통신 결과 데이터 가공
        // 데이터 저장
        // 사용자 반환
        return null;
    }
}
