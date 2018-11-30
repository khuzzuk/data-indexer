package com.example.dataindexer.datasearcher.doors;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class DoorsServiceAspect {
    @Pointcut("execution(* com.example.dataindexer.datasearcher.doors.DoorsDocumentService.*(..))")
    public void loggingPointcut() {}

    @Before("loggingPointcut()")
    public void doLog() {
        log.warn("catch");
    }
}
