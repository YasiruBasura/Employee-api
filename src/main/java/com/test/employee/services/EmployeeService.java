package com.test.employee.services;

import com.test.employee.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    List<Employee> getAllEmployees();

    boolean deleteEmployee(Long id);
}
