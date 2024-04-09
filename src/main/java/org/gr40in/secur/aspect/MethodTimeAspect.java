package org.gr40in.secur.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
@Aspect
public class MethodTimeAspect {

    @Around("execution(* org.gr40in.secur.service.UserService.*(..))")
    public Object timeLogMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = LocalDateTime.now().getNano();
        System.out.println("am i work ?");
        log.info("method start - " + startTime);
        Object proceed = proceedingJoinPoint.proceed();
        long endTime = LocalDateTime.now().getNano();
        log.info("method finished - " + endTime);
        log.info("method running time = " + (endTime - startTime) / 1000_000 + " msec");
        return proceed;
    }
}
