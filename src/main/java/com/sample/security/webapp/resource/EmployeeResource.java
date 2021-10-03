package com.sample.security.webapp.resource;

import com.sample.security.webapp.dto.EmployeeCreateRequest;
import com.sample.security.webapp.entity.Employee;
import com.sample.security.webapp.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/employees")
@Validated
public class EmployeeResource {

    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@Valid EmployeeCreateRequest employeeCreateRequest) {
        Employee employee = Employee.builder().firstName(employeeCreateRequest.getFirstName()).middleName(employeeCreateRequest.getMiddleName()).lastName(employeeCreateRequest.getLastName()).dateOfBirth(employeeCreateRequest.getDateOfBirth()).build();
        Employee savedEmployee = employeeService.create(employee);
        return savedEmployee.getId();
    }

}
