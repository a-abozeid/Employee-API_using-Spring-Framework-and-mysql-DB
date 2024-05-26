package com.test.testing.service.impl;

import com.test.testing.entity.employee;
import com.test.testing.dto.employeeDTO;
import com.test.testing.exception.notFound;
import com.test.testing.service.employeeService;
import com.test.testing.mapper.empolyee.Mapper;
import com.test.testing.repository.employeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class employeeServiceImpl implements employeeService{
    private employeeRepository employeeRepository;

    @Override
    public employeeDTO createEmployee(employeeDTO employeeDTO) {
        employee employee = Mapper.mapToEmployee(employeeDTO);
        employee savedEmployee = employeeRepository.save(employee);
        return Mapper.mapToEmployeeDTO(savedEmployee);
    }

    @Override
    public employeeDTO getEmployeeById(Integer id) {
        employee employee = employeeRepository.findById(id)
                .orElseThrow(()->
                        new notFound("There is no employee with id " + id));
        return Mapper.mapToEmployeeDTO(employee);
    }

    @Override
    public List<employeeDTO> getAllEmployees() {
        List<employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> Mapper.mapToEmployeeDTO(employee)).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public employeeDTO updateEmployee(Integer id, employeeDTO updatedEmployee) {
        employee employee = employeeRepository.findById(id)
                .orElseThrow(()->
                        new notFound("There is no employee with id " + id));

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        return Mapper.mapToEmployeeDTO(employeeRepository.save(employee));
    }

    @Override
    public void deleteEmployee(Integer id) {
        employee employee = employeeRepository.findById(id)
                .orElseThrow(()->
                        new notFound("There is no employee with id " + id));
        employeeRepository.deleteById(id);
    }
}
