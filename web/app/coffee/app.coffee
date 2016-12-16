class App
  constructor: ->
    @homeController = new HomeController()
    @employeeController = new EmployeeController()

  start: ->
    @routes =
      '/': @homeController.index
      '/employees': @employeeController.list
      '/employees/:id' : @employeeController.show
      '/employee/new' : @employeeController.create
      '/employee/save' : @employeeController.save
    @urlMappings()

  urlMappings: ->
    router = Router(@routes)
    router.init()
