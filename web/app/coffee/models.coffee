class Employee
  constructor: (options) ->
    { @id, @firstName, @lastName, @birthDate, @hireDate, @gender } = options

  fullName : ->
    "#{@firstName} #{@lastName}"

class EmployeesPage
  constructor: (employeesList, @links, @pageInfo) ->
    @employeesList =(new Employee(e) for e in employeesList)

