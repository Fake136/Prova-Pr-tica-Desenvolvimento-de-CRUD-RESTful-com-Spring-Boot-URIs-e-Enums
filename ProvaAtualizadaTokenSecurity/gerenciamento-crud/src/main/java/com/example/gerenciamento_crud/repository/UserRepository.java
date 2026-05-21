package com.example.gerenciamento_crud.repository;

import com.example.gerenciamento_crud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);
}