package com.tutorial.authorizaton_server.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tutorial.authorizaton_server.dto.CreateAppUserDto;
import com.tutorial.authorizaton_server.dto.MessageDto;
import com.tutorial.authorizaton_server.entity.AppUser;
import com.tutorial.authorizaton_server.entity.Role;
import com.tutorial.authorizaton_server.enums.RoleName;
import com.tutorial.authorizaton_server.repository.AppUserRepository;
import com.tutorial.authorizaton_server.repository.RoleRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class AppUserService {
  private final AppUserRepository appUserRepository;
  private final RoleRepository roleRepository;
  private final PasswordEncoder passwordEncoder;

  public MessageDto createUser(CreateAppUserDto dto) {
    AppUser appUser = AppUser.builder()
        .username(dto.username())
        .password(passwordEncoder.encode(dto.password()))
        .build();
    Set<Role> roles = new HashSet<>();
    dto.roles().forEach(r -> {
      Role role = roleRepository.findByRole(RoleName.valueOf(r))
        .orElseThrow(() -> new RuntimeException("Role not Found"));

      roles.add(role);
    });
    appUser.setRoles(roles);
    appUserRepository.save(appUser);
    return new MessageDto("User saved");
  }
}
