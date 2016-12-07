package com.makingdevs.repositories

import com.makingdevs.model.Employee
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

/**
 * Created by makingdevs on 11/25/16.
 */
interface EmployeeRepository extends  PagingAndSortingRepository<Employee, Integer> {

  Employee findByFirstNameAndLastName(@Param("firstName") String firstName,@Param("lastName") String lastName)

}