class App
  constructor: ->
    @homeController = new HomeController()
    @employeeController = new EmployeeController()

  start: ->
    @routes =
      '/': @homeController.index
      '/employees': @employeeController.list
      '/employees/new' : @employeeController.create
      '/employee/:id' : @employeeController.show
    @urlMappings()

  urlMappings: ->
    router = Router(@routes)
    router.init()
