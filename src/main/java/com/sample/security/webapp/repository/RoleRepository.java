package com.sample.security.webapp.repository;

import com.sample.security.webapp.entity.Role;
import com.sample.security.webapp.entity.RoleWithEmployeeCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, String> {

    Optional<Role> findByNameEquals(String name);

    @Query("select role.id as id, count(re.id) as employeeCount from Role role " +
            "join role.employees re where role.id = ?1 group by role.id")
    RoleWithEmployeeCount findUserCountAssignedToRole(String roleId);

}