package com.sample.security.webapp.service;

import com.sample.security.webapp.entity.Role;
import com.sample.security.webapp.exception.ResourceInConflictException;
import com.sample.security.webapp.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@SpringBootTest
@Transactional
public class RoleServiceTests {

    @Autowired
    private RoleService roleService;

    @Test
    void given_non_existing_role_id_then_get_should_throw_exception() {
        assertThatExceptionOfType(ResourceNotFoundException.class).isThrownBy(() -> roleService.get("some_non_existing_role_id"));
    }

    @Test
    void given_correct_details_then_create_should_be_successful() {
        Role role = roleService.create("ROLE1", "Some description");
        Role dbRole = roleService.get(role.getId());
        assertThat(role.getId()).isEqualTo(dbRole.getId());
        assertThat(role.getDescription()).isEqualTo(dbRole.getDescription());

    }

    @Test
    void given_duplicate_name_then_create_should_throw_exception() {
        roleService.create("ROLE1", "Some description");
        assertThatExceptionOfType(ResourceInConflictException.class).isThrownBy(() -> roleService.create("ROLE1", "Some other description"));
    }

}
