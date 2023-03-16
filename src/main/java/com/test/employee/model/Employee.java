package com.test.employee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor  //getting the constructor with all the arguments
@NoArgsConstructor   //getting the constructor with no arguments
public class Employee {
    private long id;
    private String firstName;
    private String lastName;
    private String emailId;
}
