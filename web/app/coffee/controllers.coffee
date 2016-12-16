class ViewResolver
  @mergeViewWithModel = (templateName, model) ->
    source = $(templateName).html()
    template = Handlebars.compile source
    template model

class HomeController
  constructor: ->

  index: ->
    html = ViewResolver.mergeViewWithModel "#home-template", {}
    $("#main").html html

class EmployeeController
  constructor: ->


  list: ->
    $.get("http://localhost:8080/webservices/employees").done(
      (result) ->
        employeesPage = new EmployeesPage(result._embedded.employees, result._links, result.page)
        html = ViewResolver.mergeViewWithModel "#employees-template", employeesPage
        $("#main").html html
    ).fail( (error) ->
      console.log error
    )
  create: ->
    html = ViewResolver.mergeViewWithModel "#new-employee-template", {}
    $("#main").html html
    $("form#employee").formValidation(
      framework : 'bootstrap'
      icon:
        valid: 'glyphicon glyphicon-ok'
        invalid: 'glyphicon glyphicon-remove'
        validating: 'glyphicon glyphicon-refresh'
      feedbackIcons:
        valid: 'glyphicon glyphicon-ok'
        invalid: 'glyphicon glyphicon-remove'
        validating: 'glyphicon glyphicon-refresh'
      fields:
        firstName:
          validators:
            notEmpty:
              message : "Rellena este campo..."
    ).on('submit', (e) ->
      console.log "Enviando forma"
      e.preventDefault()
    ).on('success.form.fv', (e) ->
      console.log "Enviando forma estilo"
      e.preventDefault()
    )

  show: (id) ->
    console.log "employee - show #{id}"
  save: ->
    data =
      firstName : $("#firstName").val()
      lastName : $("#lastName").val()
      birthDate : $("#birthDate").val()
      hireDate : $("#hireDate").val()
      gender : $("#gender").val()
    employee = new Employee(data)
    console.log employee
