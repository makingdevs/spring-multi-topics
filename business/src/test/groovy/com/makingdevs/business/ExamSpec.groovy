package com.makingdevs.business

import com.makingdevs.aspects.AspectsConfig
import com.makingdevs.aspects.TxConfig
import com.makingdevs.business.impl.ExamImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import spock.lang.Unroll

import java.lang.Void as Should
/**
 * Created by neodevelop on 26/11/16.
 */
@ContextConfiguration(classes = [BusinessConfig, AspectsConfig, TxConfig])
class ExamSpec extends Specification{

    @Autowired
    ExamImpl exam

    Should "Making and exam"(){
        when:
        exam.doExam()
        then:
        true
    }

}
