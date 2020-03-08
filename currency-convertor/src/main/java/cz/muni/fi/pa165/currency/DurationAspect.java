package cz.muni.fi.pa165.currency;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class DurationAspect {
    @Around("execution(* cz.muni.fi.pa165.currency.CurrencyConvertor+.*(..))")
    public Object printOutDuration(ProceedingJoinPoint joinPoint) throws Throwable {
        long time1 = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        System.out.println("Method: " + joinPoint.getSignature() + ", took " + (System.currentTimeMillis() - time1) + "ms.");

        return result;
    }
}