package com.makingdevs.aspects

import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.springframework.stereotype.Component

/**
 * Created by makingdevs on 12/2/16.
 */
@Component
@Aspect
class AppPointcuts {

  @Pointcut("execution(public * com.makingdevs.business..*(..)) && !execution(* *.getMetaClass(..))")
  void pointcutBusinessApp(){ }
}
