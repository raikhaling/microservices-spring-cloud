package com.khaling.microservices.currencyexchangeservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${currency-rate}")
    private String current_currency;

    @GetMapping
    public String getValue(){
        return current_currency;
    }
}
