class Employee
  constructor: (options) ->
    { @id, @firstName, @lastName, @birthDate, @hireDate, @gender } = options

  fullName : ->
    "#{@firstName} #{@lastName}"
