package com.test.employee.services.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//the purpose of creating this Model is to create a similar model to EmployeeEntitiy
//that can interact with the UI
@Data
@AllArgsConstructor  //getting the constructor with all the arguments
@NoArgsConstructor   //getting the constructor with no arguments
public class Employee {
    private long id;
    private String firstName;
    private String lastName;
    private String emailId;
}
