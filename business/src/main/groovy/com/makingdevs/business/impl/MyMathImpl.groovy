package com.makingdevs.business.impl

import com.makingdevs.business.MyMath
import com.makingdevs.repositories.EmployeeRepository
import groovy.transform.CompileStatic
import groovy.transform.TypeChecked
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by neodevelop on 26/11/16.
 */
@Service
@Slf4j
class MyMathImpl implements MyMath {

    @Override
    @TypeChecked
    List<Integer> primesTo(int i) {
        log.info "${MyMathImpl.class.name} -  primesTo"
        [2,3,5,7]
    }
}
