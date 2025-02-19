package com.spring_aop_advance.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RetryAspect {

    @Around("@annotation(com.spring_aop_advance.annotation.Retryable)")
    public Object retryLogic(ProceedingJoinPoint joinPoint) throws Throwable {
        int maxRetries = 3, attempt = 0;
        while (attempt < maxRetries) {
            try {
                return joinPoint.proceed();
            } catch (Exception ex) {
                attempt++;
                if (attempt == maxRetries) throw ex;
            }
        }
        return null;
    }
}

