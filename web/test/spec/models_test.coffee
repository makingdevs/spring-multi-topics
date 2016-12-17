do ->
  'use strict'
  describe 'the model Employee', ->
    describe 'the properties of employee', ->
      it 'should create an employee', ->
        employee = new Employee({firstName:"Juan"})
        employee.firstName.should.be.a 'string'
    describe 'the age of employee', ->
      it 'should show the right date', ->
        employee = new Employee({hireDate:"2013-02-08 24:00:00.000"})
        expect(employee.hireDateWithFormat()).to.equal("08, 02 2013")
