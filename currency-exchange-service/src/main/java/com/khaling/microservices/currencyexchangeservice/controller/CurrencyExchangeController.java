package com.khaling.microservices.currencyexchangeservice.controller;

import com.khaling.microservices.currencyexchangeservice.entity.CurrencyExchange;
import com.khaling.microservices.currencyexchangeservice.repo.CurrencyExchangeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
@RequiredArgsConstructor
@RestController
public class CurrencyExchangeController {

    private final Environment environment;
    private final CurrencyExchangeRepo currencyExchangeRepo;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(
            @PathVariable String from,
            @PathVariable String to){

       // CurrencyExchange currencyExchange = new CurrencyExchange(100L, from, to, BigDecimal.valueOf(120));
        //get port from environment

        CurrencyExchange currencyExchange = currencyExchangeRepo.findByFromAndTo(from, to)
                .orElseThrow(() -> new RuntimeException("No data found"));
        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);

        return currencyExchange;
    }
}
