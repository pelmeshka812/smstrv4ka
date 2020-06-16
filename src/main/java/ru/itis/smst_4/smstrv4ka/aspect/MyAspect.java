package ru.itis.smst_4.smstrv4ka.aspect;

import lombok.SneakyThrows;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
    @After(value = "execution(* ru.itis.smst_4.smstrv4ka.service.*.*(*))")
    public void after(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + " executed");
    }


    @Around(value = "execution(* ru.itis.smst_4.smstrv4ka.service.SignUpService.signUp(*))")
    public void around(ProceedingJoinPoint joinPoint) {
        long startTime = System.nanoTime();
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            System.out.println("Exception during aspect");
        }
        long endTime = System.nanoTime();
        System.out.println("Time of executing signUp method " + (endTime - startTime));
    }
}
