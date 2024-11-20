package com.tutorial.authorizaton_server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.authorizaton_server.dto.CreateAppUserDto;
import com.tutorial.authorizaton_server.dto.MessageDto;
import com.tutorial.authorizaton_server.service.AppUserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
  private final AppUserService appUserService;

  @PostMapping("/create")
  public ResponseEntity<MessageDto> createUser(@RequestBody CreateAppUserDto dto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(appUserService.createUser(dto));
  }
}
