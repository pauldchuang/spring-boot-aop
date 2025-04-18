package com.example.demo.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.demo.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) throws Throwable {
        System.out.println("Before " + joinPoint.getSignature().getName());
    }


    @Around("execution(* com.example.demo.service.*.*(..))")
    public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Around before the method: " + pjp.getSignature().getName());
        Object result = pjp.proceed();
        System.out.println("Around after the method: " + pjp.getSignature().getName());
        return result;
    }

    @After("execution(* com.example.demo.service.*.*(..))")
    public void logAfter(JoinPoint joinPoint) throws Throwable {
        System.out.println("After " + joinPoint.getSignature().getName());
    }

    @Around("@annotation(com.example.demo.annotation.TrackTime)")
    public Object trackTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = pjp.proceed();
        long end = System.currentTimeMillis();
        System.out.println("Execution time: " + (end - start) + " ms");
        return result;
    }
}