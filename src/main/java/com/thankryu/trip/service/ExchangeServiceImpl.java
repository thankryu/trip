package com.thankryu.trip.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thankryu.trip.dto.ExchangeRateDto;
import com.thankryu.trip.dto.ExchangeRequestDto;
import com.thankryu.trip.entity.item.ExchangeRateEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

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

        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(url);
        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.URI_COMPONENT);
        WebClient webClient = WebClient
                .builder()
                .uriBuilderFactory(factory)
                .baseUrl(url)
                .build();

        // 환율 API
        Flux<ExchangeRateDto> exchangeRateDtoList = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("authkey", authkey)
                                .queryParam("searchdate", "20230306")
                                .queryParam("data", "AP01")
                                .build())
                .retrieve()
                .bodyToFlux(ExchangeRateDto.class);

        List<ExchangeRateDto> exchangeRateDtos = exchangeRateDtoList
                .collect(Collectors.toList())
                .share().block();

        // 조회한 내용 entity에 담기
        List<ExchangeRateEntity> rateList = exchangeRateDtos.stream()
                .map(rateDto -> {
                    ExchangeRateEntity entity = ExchangeRateEntity.builder()
                            .curNm(rateDto.getCur_nm())
                            .curUnit(rateDto.getCur_unit())
                            .ttb(rateDto.getTtb())
                            .tts(rateDto.getTts())
                            .dealBasR(rateDto.getDeal_bas_r())
                            .bkpr(rateDto.getBkpr())
                            .yyEfeeR(rateDto.getYy_efee_r())
                            .tenDdEfeeR(rateDto.getTen_dd_efee_r())
                            .kftcDealBasR(rateDto.getKftc_deal_bas_r())
                            .kftcBkpr(rateDto.getKftc_bkpr())
                            .build();
                    return entity;
                })
                .collect(Collectors.toList());
        return null;
    }
}
