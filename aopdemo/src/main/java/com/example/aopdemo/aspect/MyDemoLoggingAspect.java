package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    // this is where we add all of our related advices for logging

    // let's start with a @Before advice
//    @Before("execution(public void addAccount())")
//    @Before("execution(public void com.example.aopdemo.dao.AccountDAO.addAccount())")
//    @Before("execution(public void add*(com.example.aopdemo.Account, ..))")
    @Before("com.example.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(){
        System.out.println("/n=====>>> Executing @Before advice on addAccount()");
    }

}
