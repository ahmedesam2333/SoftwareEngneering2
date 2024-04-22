package com.TaskMicroservice.ASOP;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * Aspect for logging method execution in the TaskMicroservice service layer.
 */
@Aspect
@Component
public class LoggingAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * Logs before the execution of methods in the TaskMicroservice service layer.
     * @param joinPoint The join point representing the method being executed.
     */
    @Before("execution(* com.TaskMicroservice.Service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Executing method: " + joinPoint.getSignature().toShortString());
    }
    /**
     * Logs after the execution of methods in the TaskMicroservice service layer.
     * @param joinPoint The join point representing the method being executed.
     * @param result The result returned by the method.
     */
    @AfterReturning(pointcut = "execution(* com.TaskMicroservice.Service.*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("Method: " + joinPoint.getSignature().toShortString() + " returned: " + result);
    }
}