package com.thankryu.trip.api;

import com.thankryu.trip.dto.ExchangeRateDto;
import com.thankryu.trip.dto.ExchangeRequestDto;
import com.thankryu.trip.service.ExchangeService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exchange")
@Slf4j
@RequiredArgsConstructor
public class ExchangeApiController {

    private final ExchangeService exchangeService;

    /**
     * 환율 정보 조회
     * @param ExchangeRequestDto
     * @return ExchangeRateDto
     */
    @GetMapping("/info")
    public Result getExchange(ExchangeRequestDto dto){

        ExchangeRateDto result = exchangeService.getExchange(dto);
        return new Result(result);
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T data;
    }
}
