package com.app.Taskaty.ASOP;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class LoggingAspect {
    private final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
    @Before("execution(* com.UserMicroservice.Service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.debug("Executing method: {}", joinPoint.getSignature().toShortString());
    }
    @AfterReturning(pointcut = "execution(* com.UserMicroservice.Service.*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.debug("Method: {} returned: {}", joinPoint.getSignature().toShortString(), result);
    }
}