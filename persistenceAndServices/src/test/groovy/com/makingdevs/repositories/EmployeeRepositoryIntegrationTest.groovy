package com.makingdevs.repositories

import com.makingdevs.config.AppConfig
import com.makingdevs.model.Employee
import com.makingdevs.model.Gender
import org.junit.After
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.annotation.Rollback
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.transaction.AfterTransaction
import org.springframework.test.context.transaction.BeforeTransaction
import org.springframework.test.context.transaction.TransactionConfiguration
import org.springframework.transaction.annotation.Transactional

/**
 * Created by makingdevs on 11/25/16.
 */
@RunWith(SpringJUnit4ClassRunner)
@ContextConfiguration(classes = [AppConfig])
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional(readOnly = true)
class EmployeeRepositoryIntegrationTest {
  @Autowired EmployeeRepository employeeRepository

  @Before
  void before(){
    println "Before"
  }

  @After
  void after(){
    println "after"
  }

  @BeforeTransaction
  void beforeTx(){
    println "Before TX"
  }

  @AfterTransaction
  void afterTx(){
    println "After Tx"
  }

  @Test
  void test1CountEmployees(){
    println employeeRepository.count()
    assert employeeRepository.count() > 0
  }

  @Test
  void test2CreateEmployee(){
    Employee e = new Employee(
        firstName: "Juan",
        lastName: "Reyes",
        gender: Gender.M,
        birthDate: new Date() - (365*29),
        hireDate: new Date() - (365*5))
    Employee saveEmployeee = employeeRepository.save(e)
    assert saveEmployeee.id
  }

  @Test
  @Transactional
  @Rollback(true)
  void test3FindEmployee(){
    Employee e = employeeRepository.findByFirstNameAndLastName("Juan","Reyes")
    e = employeeRepository.findByFirstNameAndLastName("Juan","Reyes")
    assert e
    assert e.id
  }

  @Test
  void test4DeleteEmployee(){
    Employee e = employeeRepository.findByFirstNameAndLastName("Juan","Reyes")
    assert e
    Thread.sleep(7000)
    employeeRepository.delete(e)
    Employee e2 = employeeRepository.findByFirstNameAndLastName("Juan","Reyes")
    assert !e2
  }
}
