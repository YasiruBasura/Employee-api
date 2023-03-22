//the repositary will interact with the database to save the data
package com.test.employee.repository;

import com.test.employee.services.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository <EmployeeEntity,Long> {  //this jpa repositary is of type EmployeeEntity
}
