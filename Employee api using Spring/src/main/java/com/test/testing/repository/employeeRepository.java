package com.test.testing.repository;

import com.test.testing.entity.employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface employeeRepository extends JpaRepository<employee, Integer> {

}
