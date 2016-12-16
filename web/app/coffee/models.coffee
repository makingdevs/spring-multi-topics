class Employee
  constructor: (options) ->
    { @id, @firstName, @lastName, @birthDate, @hireDate, @gender } = options

  fullName : ->
    "#{@firstName} #{@lastName}"

  birthDateWithFormat : ->
    moment(@birthDate).format("dddd, MM YYYY")

  hireDateWithFormat : ->
    moment(@hireDate).format("dddd, MM YYYY")

  timeWorking : ->
    moment(@hireDate).fromNow()

class EmployeesPage
  constructor: (employeesList, @links, @pageInfo) ->
    @employeesList =(new Employee(e) for e in employeesList)

