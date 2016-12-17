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
    @employeeManager = EmployeeManager.getInstance()

  list: (page = 0, size = 10) =>
    onSuccess = (result) ->
      employeesPage = new EmployeesPage(result._embedded.employees, result._links, result.page)
      html = ViewResolver.mergeViewWithModel "#employees-template", employeesPage
      $("#main").html html
    onError = () -> console.log "Errorz"
    params =
      page : page
      size : size
    @employeeManager.list(params, onSuccess, onError)

  create: =>
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
            stringLength:
              min: 4
              max: 40
              message: "Pon tu nombre Papu!!!"
        lastName:
          validators:
            notEmpty:
              message : "Pon tu lastname"
            stringLength:
              min: 4
              max: 40
              message: "Pon tu apallido Papawh!!!"
        gender:
          validators:
            notEmpty:
              message : "Pon tu genero quimera!!!!"

    ).on('success.form.fv', (e) =>
      console.log "Enviando forma estilo"
      e.preventDefault()
      @save()
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
    #$.post("url", e).done()
