package com.partha.lrn.demo;


import com.partha.lrn.demo.service.GreetingService;
import com.partha.lrn.demo.service.OutputService;
import com.partha.lrn.demo.service.TimeService;

public class Application {

    public static void main(String[] args) throws Exception {
        GreetingService greetingService = new GreetingService("Hello");
        TimeService timeService = new TimeService(true);
        OutputService outputService = new OutputService(greetingService, timeService);

        for (int i=0;i<5;i++){
            outputService.generateOutput("Frank");
            Thread.sleep(5000);
        }
    }
}
