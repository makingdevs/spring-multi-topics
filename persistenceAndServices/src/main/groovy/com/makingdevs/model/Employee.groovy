package com.makingdevs.model

import groovy.transform.Canonical
import org.hibernate.annotations.GenericGenerator

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Created by makingdevs on 11/25/16.
 */
@Canonical
@Entity(name = "employees")
class Employee {
  @Id
  @GeneratedValue(generator = "incremental")
  @GenericGenerator(name = "incremental", strategy = "increment")
  @Column(name = "emp_no")
  Integer id

  @Column(name = "first_name")
  String firstName

  @Column(name = "last_name")
  String lastName

  @Column(name = "birth_date")
  Date birthDate

  @Column(name = "hire_date")
  Date hireDate

  @Enumerated(EnumType.STRING)
  Gender gender = Gender.F
}
