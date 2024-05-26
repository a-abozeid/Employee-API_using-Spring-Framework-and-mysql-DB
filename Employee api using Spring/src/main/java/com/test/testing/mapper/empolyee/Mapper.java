package com.test.testing.mapper.empolyee;

import com.test.testing.dto.employeeDTO;
import com.test.testing.entity.employee;

public class Mapper {
    public static employeeDTO mapToEmployeeDTO(employee employee){
        return new employeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }
    public static employee mapToEmployee(employeeDTO employeeDTO){
        return new employee(
                employeeDTO.getId(),
                employeeDTO.getFirstName(),
                employeeDTO.getLastName(),
                employeeDTO.getEmail()
        );
    }
}
