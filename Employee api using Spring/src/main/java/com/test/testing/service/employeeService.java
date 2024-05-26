package com.test.testing.service;

import com.test.testing.dto.employeeDTO;

import java.util.List;

public interface employeeService {
    employeeDTO createEmployee(employeeDTO employeeDTO);
    employeeDTO getEmployeeById(Integer id);
    List<employeeDTO> getAllEmployees();
    employeeDTO updateEmployee(Integer id, employeeDTO updatedEmployee);
    void deleteEmployee(Integer id);
}
