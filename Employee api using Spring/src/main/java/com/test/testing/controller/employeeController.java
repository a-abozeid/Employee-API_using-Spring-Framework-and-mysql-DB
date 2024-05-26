package com.test.testing.controller;

import com.test.testing.entity.employee;
import com.test.testing.dto.employeeDTO;
import com.test.testing.service.employeeService;
import com.test.testing.mapper.empolyee.Mapper;
import com.test.testing.repository.employeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@AllArgsConstructor
public class employeeController {
    private employeeService employeeService;

    @PostMapping
    public ResponseEntity<employeeDTO> createEmployee(@RequestBody employeeDTO employeeDTO){
        employeeDTO savedEmployee = employeeService.createEmployee(employeeDTO);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<employeeDTO> getEmployeeById(@PathVariable("id") Integer id) {
        employeeDTO fetchedEmployee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(fetchedEmployee);
    }

    @GetMapping
    public ResponseEntity<List<employeeDTO>> getAllEmployees(){
        List<employeeDTO> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @PutMapping("{id}")
    public  ResponseEntity<employeeDTO> updateEmployee(@PathVariable("id") Integer id, @RequestBody employeeDTO updatedEmployee){
        employeeDTO fetchedEmployee = employeeService.updateEmployee(id, updatedEmployee);
        return ResponseEntity.ok(fetchedEmployee);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Integer id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Deleted!");
    }
}
