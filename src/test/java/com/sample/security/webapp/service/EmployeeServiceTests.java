package com.sample.security.webapp.service;

import com.sample.security.webapp.entity.Employee;
import com.sample.security.webapp.exception.ResourceInConflictException;
import com.sample.security.webapp.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@SpringBootTest
@Transactional
public class EmployeeServiceTests {

    @Autowired
    private EmployeeService employeeService;

    @Test
    void given_non_existing_employee_id_then_get_should_throw_exception() {
        assertThatExceptionOfType(ResourceNotFoundException.class).isThrownBy(() -> employeeService.get("some_non_existing_emp_id"));
    }

    @Test
    void given_employee_with_id_then_create_should_throw_exception() {
        Employee employee = Employee.builder().id("ID").firstName("First Name").lastName("Last Name").dateOfBirth(LocalDate.of(1998, 12, 31)).build();
        assertThatExceptionOfType(ResourceInConflictException.class).isThrownBy(() -> employeeService.create(employee));
    }

    @Test
    void given_employee_without_id_then_create_should_be_successful() {
        Employee employee = Employee.builder().firstName("First Name").lastName("Last Name").dateOfBirth(LocalDate.of(1998, 12, 31)).build();
        Employee savedEmployee = employeeService.create(employee);
        assertThat(savedEmployee.getId()).isNotNull();
        Employee dbEmployee = employeeService.get(savedEmployee.getId());
        assertThat(dbEmployee.getFirstName()).isEqualTo(savedEmployee.getFirstName());
        assertThat(dbEmployee.getMiddleName()).isEqualTo(savedEmployee.getMiddleName());
        assertThat(dbEmployee.getLastName()).isEqualTo(savedEmployee.getLastName());
        assertThat(dbEmployee.getDateOfBirth()).isEqualTo(savedEmployee.getDateOfBirth());
    }

}
