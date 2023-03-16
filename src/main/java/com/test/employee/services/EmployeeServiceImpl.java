package com.test.employee.services;

import com.test.employee.entity.EmployeeEntity;
import com.test.employee.model.Employee;
import com.test.employee.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;    //object of the repositary

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        EmployeeEntity employeeEntity= new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);        //save method already available in the employee repositary
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeeEntities
                =employeeRepository.findAll();    //getting all the data on employee repositary
        //converting the employee entity to the listofEmployee for the UI is below
        List<Employee> employees=employeeEntities
                .stream()
                .map(emp->new Employee(  //used the map function to convert the employee entity to employee
                        emp.getId(),
                        emp.getFirstName(),
                        emp.getLastName(),
                        emp.getEmailId()))
                .collect(Collectors.toList());

        return employees;
    }
}
