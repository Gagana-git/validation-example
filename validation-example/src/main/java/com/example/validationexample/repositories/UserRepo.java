package com.example.validationexample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.validationexample.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
