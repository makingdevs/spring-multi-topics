package com.makingdevs.business

import com.makingdevs.aspects.AspectsConfig
import com.makingdevs.aspects.TxConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import spock.lang.Unroll

import java.lang.Void as Should
/**
 * Created by neodevelop on 26/11/16.
 */
@ContextConfiguration(classes = [BusinessConfig, AspectsConfig, TxConfig])
class MyMathSpec extends Specification{

    @Autowired
    MyMath myMath

    @Unroll("the prime numbers until #n are #primes")
    Should "get the prime numbers until"(){
        given:"A number"
        Integer i = n
        when:"Search a sequence of primes"
        def sequence = myMath.primesTo(i)
        then:"Get the sequence"
        sequence == primes
        where:
        n   | primes
        8   | [2,3,5,7]
        12  | [2,3,5,7,11]
        20  | [2,3,5,7,11,13,17,19]
    }

}
