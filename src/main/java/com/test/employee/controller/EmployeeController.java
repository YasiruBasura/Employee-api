package com.test.employee.controller;

import com.test.employee.model.Employee;
import com.test.employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins ="http://localhost:3001" )
@RestController
@RequestMapping("/api/v1/")

public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //define a method/api to handle the post request of the data is below
    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee){   //this returns the model object Employee(thats why the return type is Employee here)
        return employeeService.createEmployee(employee);
    }

}
