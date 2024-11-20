package com.tutorial.authorizaton_server.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.authorizaton_server.entity.Role;
import com.tutorial.authorizaton_server.enums.RoleName;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByRole(RoleName roleName);
}
