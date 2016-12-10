console.log "Hello Yeoman, how are you?"

home = ->
  console.log 'home'
list_employees = ->
  console.log 'employees'
new_employee = ->
  console.log 'new employee'

routes =
  '/': home
  '/employees': list_employees
  '/employees/new' : new_employee

router = Router(routes)
router.init()
