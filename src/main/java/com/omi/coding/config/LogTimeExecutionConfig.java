package com.omi.coding.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * Log Time Execution Config Class.
 *
 * @author Omar Ismail
 * @since 5/18/2022
 */
@Aspect
@Component
public class LogTimeExecutionConfig {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around("@annotation(com.omi.coding.config.annotation.LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        final StopWatch stopWatch = new StopWatch();

        stopWatch.start();

        Object proceed = joinPoint.proceed();

        stopWatch.stop();

        logger.info("\"{}\" executed in {} ms", joinPoint.getSignature(), stopWatch.getTotalTimeMillis());

        return proceed;
    }

}

