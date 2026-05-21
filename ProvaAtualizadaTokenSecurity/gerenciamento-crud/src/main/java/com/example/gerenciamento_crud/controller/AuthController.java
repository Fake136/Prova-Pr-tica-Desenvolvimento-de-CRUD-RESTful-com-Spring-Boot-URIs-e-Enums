package com.example.gerenciamento_crud.controller;

import com.example.gerenciamento_crud.dto.LoginDTO;
import com.example.gerenciamento_crud.dto.LoginResponseDTO;
import com.example.gerenciamento_crud.dto.RegisterDTO;
import com.example.gerenciamento_crud.entity.User;
import com.example.gerenciamento_crud.repository.UserRepository;
import com.example.gerenciamento_crud.security.TokenService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(
            @RequestBody LoginDTO data) {

        var usernamePassword =
                new UsernamePasswordAuthenticationToken(
                        data.login(),
                        data.password());

        var auth = this.manager.authenticate(usernamePassword);

        var token =
                tokenService.generateToken(
                        (User) auth.getPrincipal());

        return ResponseEntity.ok(
                new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(
            @RequestBody RegisterDTO data) {

        if (repository.findByLogin(data.login()) != null) {
            return ResponseEntity.badRequest().build();
        }

        User user = new User();

        user.setLogin(data.login());

        user.setPassword(
                encoder.encode(data.password()));

        user.setRole(data.role());

        repository.save(user);

        return ResponseEntity.ok().build();
    }
}