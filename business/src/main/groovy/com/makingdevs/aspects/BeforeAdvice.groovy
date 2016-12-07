package com.makingdevs.aspects

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

/**
 * Created by neodevelop on 26/11/16.
 */
@Component
@Aspect
@Slf4j
@CompileStatic
class BeforeAdvice {

    //@Before("execution(* com.makingdevs.business.impl.*..*(..))")
    //@Before("target(com.makingdevs.business.MyMath)")
    @Before("com.makingdevs.aspects.AppPointcuts.pointcutBusinessApp()")
    void before(JoinPoint jp){
        //log.warn "Before: ${jp.target.class}"
        log.debug "Before: ${jp.signature.name}(${jp.args})"
    }

  /*
    @After("execution(public * com.makingdevs.business..*(..))")
    void after(JoinPoint jp){
        log.debug "After: ${jp.signature.name}(${jp.args})"
    }

    @AfterReturning("execution(public * com.makingdevs.business..*(..))")
    void afterReturning(JoinPoint jp){
        log.debug "AfterReturning: ${jp.signature.name}(${jp.args})"
    }

    @Around("execution(public * com.makingdevs.business..*(..))")
    def around(ProceedingJoinPoint pjp){
        log.debug "Around(Before): ${pjp.signature.name}(${pjp.args})"
        def val = pjp.proceed() // Esta es la ex del método original
        log.debug "Around(After): ${pjp.signature.name}(${pjp.args})"
        val
    }
    */
}
