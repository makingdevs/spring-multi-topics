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
    many_employees =
      'employees': [
        new Employee(id:1, firstName:"Juan",lastName:"Zuñiga"),
        new Employee(id:2, firstName:"Rock",lastName:"Mtz"),
        new Employee(id:3, firstName:"Carlo",lastName:"Padilla")
      ]
    html = ViewResolver.mergeViewWithModel "#employees-template", many_employees
    $("#main").html html
  create: ->
    html = ViewResolver.mergeViewWithModel "#new-employee-template", {}
    $("#main").html html
  show: (id) ->
    console.log "employee - show #{id}"
