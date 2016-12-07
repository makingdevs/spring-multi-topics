package com.makingdevs.aspects

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component

/**
 * Created by makingdevs on 12/2/16.
 */
@Aspect
@Component
@CompileStatic
@Slf4j
class BenchmarkAdvice {

  @Around("com.makingdevs.aspects.AppPointcuts.pointcutBusinessApp()")
  def microBenchmark(ProceedingJoinPoint pjp){
    def startTime = System.currentTimeMillis()
    log.info "******* ${pjp.target.class.simpleName}.${pjp.signature.name}(${pjp.args.join(',')}) *******"
    def result = pjp.proceed()
    def endTime = System.currentTimeMillis()
    log.info("BM for ${pjp.target.class.simpleName}.${pjp.signature.name}(${pjp.args.join(',')}) : ${endTime - startTime} ms")
    result
  }
}
