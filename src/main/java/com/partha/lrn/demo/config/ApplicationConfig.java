package com.partha.lrn.demo.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.partha.lrn.demo.service.GreetingService;
import com.partha.lrn.demo.service.OutputService;
import com.partha.lrn.demo.service.TimeService;

@Configuration
public class ApplicationConfig {

    @Value("Hello")
    private String greeting;

    @Autowired
    private GreetingService greetingService;
    @Autowired
    private TimeService timeService;

    @Bean
    public TimeService timeService(){
        return new TimeService(true);
    }

    @Bean
    public OutputService outputService(){
        return new OutputService(greetingService, timeService);
    }

    @Bean
    public GreetingService greetingService(){
        return new GreetingService(greeting);
    }
}