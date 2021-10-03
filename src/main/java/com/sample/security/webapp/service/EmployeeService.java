package com.sample.security.webapp.service;

import com.sample.security.webapp.entity.Employee;
import com.sample.security.webapp.exception.ResourceInConflictException;
import com.sample.security.webapp.exception.ResourceNotFoundException;
import com.sample.security.webapp.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee get(String employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee", employeeId));
    }

    public Employee create(Employee employee) {
        if(employee.getId() != null) {
            throw new ResourceInConflictException("Employee", "id", employee.getId());
        }
        return employeeRepository.save(employee);
    }

}
