package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class AopExpressions {
    @Pointcut("execution(* com.example.aopdemo.dao.*.*(..))")
    public void forDAOPackage(){}

    //create a pointcut for getter methods
    @Pointcut("execution(* com.example.aopdemo.dao.*.get*(..))")
    public void getter(){}

    //create a pointcut for setter methods
    @Pointcut("execution(* com.example.aopdemo.dao.*.set*(..))")
    public void setter(){}

    //create a pointcut: include package ... exclude getter/setter
    @Pointcut("forDAOPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter(){}
}
