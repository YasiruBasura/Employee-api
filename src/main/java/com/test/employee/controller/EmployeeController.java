package com.test.employee.controller;

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
//Here we have used @Autowired to inject dependencies.And within that we have created the constructor.
    //tells Spring to inject an instance of EmployeeService into this constructor when creating a new
    // instance of the EmployeeService class.
    private final EmployeeService employeeService;
//    In the above example, private EmployeeService employeeService;
//    is a declaration of a private field called employeeService of
//    type EmployeeService in the Controller class. This field is used to
//    hold a reference to an instance of the EmployeeService interface.

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    } //this is the constructor created by the @Autowired annotation

    //define a method/api to handle the post request of the data is below
    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee){   //this returns the model object Employee(thats why the return type is Employee here)
        return employeeService.createEmployee(employee);
        //when you hit /api/v1/api/v1 this particular method will be called
        //RequestBody gets all the Json data when a POST request is made and pass it as employee
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



