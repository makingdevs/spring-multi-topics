class EmployeeManager

  baseUrl = "http://localhost:8080/webservices"
  entityUrl = "/employees"
  instance = null

  @getInstance: ->
    if not instance
      instance = new @
      instance.init()
    instance

  init: (name = "employeeManager") ->
    console.log "#{name} initiated"

  list: (params, onSuccess, onError) ->
    queryParams = ("#{k}=#{v}" for k,v of params).join('&')
    $.get("#{baseUrl}#{entityUrl}?#{queryParams}").done(onSuccess).fail(onError)

  save: (employee) ->
