package com.makingdevs.business.impl

import com.makingdevs.business.MyMath
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by makingdevs on 12/2/16.
 */
@Service
@Slf4j
class ExamImpl {
  @Autowired
  MyMath myMath
  @Autowired
  EvaluationImpl evaluation

  def doExam(){
    myMath.primesTo(100)
    evaluation.doEvaluate()
    log.info "Making an Exam"
  }
}
