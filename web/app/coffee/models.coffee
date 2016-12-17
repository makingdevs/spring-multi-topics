class Employee
  constructor: (options) ->
    { @id, @firstName, @lastName, @birthDate, @hireDate, @gender } = options

  dataForSend: ->
    { @id, @firstName, @lastName, @birthDate, @hireDate, @gender }
    
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
    @pageInfo.previousPage =
      if @pageInfo.number == 0
        0
      else
        @pageInfo.number - 1
    @pageInfo.nextPage =
      if @pageInfo.number == @pageInfo.totalPages
        @pageInfo.totalPages
      else
        @pageInfo.number + 1
