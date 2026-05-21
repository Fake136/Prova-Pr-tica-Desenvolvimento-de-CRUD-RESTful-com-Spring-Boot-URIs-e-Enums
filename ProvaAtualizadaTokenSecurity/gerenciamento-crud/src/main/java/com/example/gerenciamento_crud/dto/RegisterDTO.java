package com.example.gerenciamento_crud.dto;

import com.example.gerenciamento_crud.enums.Role;

public record RegisterDTO(
        String login,
        String password,
        Role role
) {
}