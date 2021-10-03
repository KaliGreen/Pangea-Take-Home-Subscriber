package com.oasis.employeeproducer.repository;

import com.oasis.employeeproducer.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Green on 25/03/2018.
 */
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Employee findByUsername(String username);
}
