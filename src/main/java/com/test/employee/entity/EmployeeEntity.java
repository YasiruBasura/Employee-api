package com.test.employee.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data  //we take this from lombok as all the getters/setters are added to it
@Table(name = "employee")
public class EmployeeEntity {

    @Id   //for every primary key we need to anotate with @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   //to automatically generate the particular id field
    private long id;  //we use private here as no one can call them by creating an object and through methods.Need to use getters and setters
    private String firstName;
    private String lastName;
    private String emailId;
}
