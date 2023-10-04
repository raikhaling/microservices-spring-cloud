package com.khaling.microservices.limitsservice.controller;

import com.khaling.microservices.limitsservice.bean.Limits;
import com.khaling.microservices.limitsservice.configuration.Config;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LimitsController {

    private final Config config;
    @GetMapping("/limits")
    public Limits retrieveLimits(){
        return new Limits(config.getMinimum(), config.getMaximum());
       // return new Limits(1,1000);
    }
}
