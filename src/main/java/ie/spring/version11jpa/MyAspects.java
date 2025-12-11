package ie.spring.version11jpa;


import ie.spring.version11jpa.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class MyAspects {
    @Before("@within(org.springframework.stereotype.Service)")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Before execution of " + joinPoint.getSignature().getName());
    }

    @Pointcut("execution( findById(..))")
    public void findByIdMethod() {
    }

    @Around(value = "findByIdMethod()")
    public Object findByIdMethodAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long end = System.currentTimeMillis();
        log.info("Execution time: " + (end - start) + "ms");
        return proceed;
    }

    @AfterThrowing(pointcut = "findByIdMethod()", throwing = "ex")
    public void logAfterThrowingFindById(NotFoundException ex) {
        log.error("An exception occured: " + ex.getMessage());
    }
}