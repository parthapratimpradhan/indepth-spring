package com.partha.lrn.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.partha.lrn.demo.aspect.Loggable;

@Service
public class GreetingService {

	 @Value("${app.greeting}")
	    private String greeting;

	@Loggable
    public String getGreeting(String name){
        return greeting + " " + name;
    }
}
