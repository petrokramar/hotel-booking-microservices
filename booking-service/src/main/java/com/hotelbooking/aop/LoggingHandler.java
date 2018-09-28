package com.hotelbooking.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LoggingHandler {

    @Pointcut("execution(* com.hotelbooking.controller.*.*(..))")
    private void forControllerPackage() {
    }

    @Pointcut("execution(* com.hotelbooking.service.*.*(..))")
    private void forServicePackage() {
    }

    @Pointcut("execution(* com.hotelbooking.repository.*.*(..))")
    private void forRepositoryPackage() {
    }

    @Pointcut("execution(* com.hotelbooking.exceptions.*.*(..))")
    private void forExceptionsPackage() {
    }

    @Pointcut("forControllerPackage() || forServicePackage() || forRepositoryPackage() || forExceptionsPackage()")
    private void forApplicationFlow() {
    }

    @AfterThrowing(pointcut = "forApplicationFlow()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {

        log.error("===> Exception in {}.{}() with cause = {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), e.getCause() != null ? e.getCause() : "NULL");

    }

    @Around("forApplicationFlow()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        if (log.isDebugEnabled()) {
            log.debug("===> Before: {}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
                    joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
        }
        try {
            Object result = joinPoint.proceed();
            if (log.isDebugEnabled()) {
                log.debug("===> After: {}.{}() with result = {}", joinPoint.getSignature().getDeclaringTypeName(),
                        joinPoint.getSignature().getName(), result);
            }
            return result;
        } catch (IllegalArgumentException e) {
            log.error("===> Illegal argument: {} in {}.{}()", Arrays.toString(joinPoint.getArgs()),
                    joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());

            throw e;
        }
    }
}