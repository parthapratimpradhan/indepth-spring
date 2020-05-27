package com.partha.lrn.demo.aspect;

import java.util.Arrays;
import java.util.Collection;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	
	private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Pointcut("@annotation(Loggable)")
	public void executeLogging() {}
	
	 @Around(value = "executeLogging()")
	    public Object logMethodCall(ProceedingJoinPoint joinPoint) throws Throwable {
	        long startTime = System.currentTimeMillis();
	        Object returnValue = joinPoint.proceed(); // Any thing before this will be executed before and anything after this will be executed after
	        long totalTime = System.currentTimeMillis()-startTime;
	        StringBuilder message = new StringBuilder("Method: ");
	        message.append(joinPoint.getSignature().getName());
	        message.append(" totalTime: ").append(totalTime).append("ms");
	        Object[] args = joinPoint.getArgs();
	        if (null!=args && args.length>0){
	            message.append(" args=[ | ");
	            Arrays.asList(args).forEach(arg->{
	                message.append(arg).append(" | ");
	            });
	            message.append("]");
	        }
	        if(returnValue instanceof Collection){
	            message.append(", returning: ").append(((Collection)returnValue).size()).append(" instance(s)");
	        }else{
	            message.append(", returning: ").append(returnValue.toString());
	        }

	        log.info(message.toString());
	        return returnValue;
	    }
}
