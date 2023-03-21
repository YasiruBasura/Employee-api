package com.test.employee.entity.controller;

import com.test.employee.model.Employee;
import com.test.employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins ="http://localhost:3000" )
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

    @GetMapping("/employee")
    public List<Employee> getAllEmployees(){
        //this method gets a list of allEmployees which are saved
        return employeeService.getAllEmployees();
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id){
        boolean deleted = false;
        deleted =employeeService.deleteEmployee(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }

}
