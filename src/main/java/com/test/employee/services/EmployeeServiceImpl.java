package com.test.employee.services;

import com.test.employee.entity.EmployeeEntity;
import com.test.employee.services.model.Employee;
import com.test.employee.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service //we call this as the Service of this business layer
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;    //object of the repositary

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }       //constructor of the EmployeeRepositary object

    @Override
    public Employee createEmployee(Employee employee) {
        EmployeeEntity employeeEntity= new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity); //copy all the values from employee and pass to the employee entity
        employeeRepository.save(employeeEntity);        //save method already available in the employee repositary
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeeEntities
                =employeeRepository.findAll();    //getting all the data on employee repositary
        //Below is,
        //converting the employee entity to the listofEmployee for the UI is below
        //converting java object data(<EmployeeEntity>) to JSON data (<Employee>).
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

    @Override
    public boolean deleteEmployee(Long id) {
        EmployeeEntity employee = employeeRepository.findById(id).get();
        employeeRepository.delete(employee);
        return true;
    }
}
