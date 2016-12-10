many_employees = ->
  [
    new Employee(id:1, firstName:"Juan",lastName:"Zuñiga"),
    new Employee(id:2, firstName:"Rock",lastName:"Mtz"),
    new Employee(id:3, firstName:"Carlo",lastName:"Padilla")
  ]

home = ->
  source = $("#home-template").html()
  template = Handlebars.compile source
  model = {}
  html = template model
  $("#main").html html
list_employees = ->
  source = $("#employees-template").html()
  template = Handlebars.compile source
  model =
    'employees': many_employees()
  html = template model
  $("#main").html html
new_employee = ->
  source = $("#new-employee-template").html()
  template = Handlebars.compile source
  model = {}
  html = template model
  $("#main").html html
show_employee = (id) ->
  console.log id


routes =
  '/': home
  '/employees': list_employees
  '/employees/new' : new_employee
  '/employee/:id' : show_employee

router = Router(routes)
router.init()
