package com.sample.security.webapp.service;

import com.sample.security.webapp.entity.Role;
import com.sample.security.webapp.exception.ResourceInConflictException;
import com.sample.security.webapp.exception.ResourceNotFoundException;
import com.sample.security.webapp.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role get(String roleId) {
        return roleRepository.findById(roleId).orElseThrow(() -> new ResourceNotFoundException("Role", roleId));
    }

    private Optional<Role> findByName(String name) {
        return roleRepository.findByNameEquals(name);
    }

    public Role create(String name, String description) {
        Optional<Role> existingRoleHolder = findByName(name);
        existingRoleHolder.ifPresent((existingRole) -> {
            throw new ResourceInConflictException("Role", "name", name);
        });
        return createRole(name, description);
    }

    private Role createRole(String name, String description) {
        Role role = Role.builder().name(name).description(description).build();
        return roleRepository.save(role);
    }

}
