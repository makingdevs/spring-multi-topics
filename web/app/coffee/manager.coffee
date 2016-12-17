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

  save: (employee, success, error) ->
    console.log employee
    console.log employee.dataForSend()
    queryParams = ("#{k}=#{v}" for k,v of employee).join('&')
    $.ajax({
      url: "#{baseUrl}#{entityUrl}"
      type: 'POST'
      data: JSON.stringify(employee.dataForSend())
      contentType: 'application/json; charset=utf-8'
      dataType: 'json'
      async: false
      success: success
    })
