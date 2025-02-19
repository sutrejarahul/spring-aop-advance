package com.spring_aop_advance.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* com.spring_aop_advance.controller.*.*(..))")
    public Object logApiCalls(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("📌 API Call: {}", joinPoint.getSignature());
        Object result = joinPoint.proceed();
        logger.info("✅ API Response: {}", result);
        return result;
    }
}

