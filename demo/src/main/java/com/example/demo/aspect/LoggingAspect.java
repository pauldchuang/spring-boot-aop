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
    public void logMethodNameBefore(JoinPoint joinPoint) throws Throwable {
        System.out.println("Before " + joinPoint.getSignature().getName() + " method");
    }


    @Around("execution(* com.example.demo.service.*.*(..))")
    public Object logTimingAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Start timing in @Around...");
        long start = System.currentTimeMillis();
        Object result = pjp.proceed();
        long end = System.currentTimeMillis();
        System.out.println("Execution time: " + (end - start) + " ms in @Around");
        return result;
    }

    @After("execution(* com.example.demo.service.*.*(..))")
    public void logMethodNameAfter(JoinPoint joinPoint) throws Throwable {
        System.out.println("After " + joinPoint.getSignature().getName() + " method");
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