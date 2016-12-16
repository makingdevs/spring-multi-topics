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
  show: (id) ->
    console.log "employee - show #{id}"
  save: ->
    console.log "Saving employee"
