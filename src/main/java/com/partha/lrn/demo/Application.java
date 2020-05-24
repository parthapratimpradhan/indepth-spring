package com.partha.lrn.demo;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.partha.lrn.demo.config.ApplicationConfig;
import com.partha.lrn.demo.service.OutputService;

public class Application {

    public static void main(String[] args) throws Exception {
    	ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    	OutputService outputService = context.getBean(OutputService.class);

        for (int i=0;i<5;i++){
            outputService.generateOutput();
            Thread.sleep(5000);
        }
    }
}
