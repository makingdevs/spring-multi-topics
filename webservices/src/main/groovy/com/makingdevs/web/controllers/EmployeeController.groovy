package com.makingdevs.web.controllers

import com.makingdevs.model.Employee
import com.makingdevs.repositories.EmployeeRepository
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.rest.webmvc.RepositoryRestController
import org.springframework.hateoas.Resources
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

/**
 * Created by neodevelop on 17/12/16.
 */
@RepositoryRestController
@Slf4j
@CompileStatic
class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository

    @RequestMapping(value="/save/some", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<?> getProducers() {
        log.info "--- List on controller ---"
        println "*"*100
        Iterable<Employee> producers = employeeRepository.findAll()
        Resources<Employee> resources = new Resources<Employee>(producers);
        //resources.add(linkTo(methodOn(ScannerController.class).getProducers()).withSelfRel());
        return ResponseEntity.ok(resources);
    }

    @RequestMapping(value="/save/some", method = RequestMethod.OPTIONS)
    @ResponseBody ResponseEntity<?> preflight(){
        log.info "--- Preflight ---"
        ResponseEntity.ok(null)
    }
}
