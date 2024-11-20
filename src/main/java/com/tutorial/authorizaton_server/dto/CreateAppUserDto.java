package com.tutorial.authorizaton_server.dto;

import java.util.List;

import lombok.Data;

public record CreateAppUserDto (
  String username,
  String password,
  List<String> roles
) {

}
