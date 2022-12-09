package com.example.validationexample.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.validationexample.dto.UserDto;
import com.example.validationexample.entities.User;
import com.example.validationexample.exceptions.UserNotFoundException;
import com.example.validationexample.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * @param userRequest
	 * @return newly added user details
	 */
	@PostMapping("/signup")
	public ResponseEntity<User> addUser(@RequestBody  @Valid  UserDto userRequest) {
		return new ResponseEntity<User>(userService.saveUser(userRequest), HttpStatus.CREATED);
	}

	/**
	 * @return all users details
	 */
	@GetMapping("/fetchAll")
	public ResponseEntity<List<User>> fetchAllUsers() {
		return ResponseEntity.ok(userService.fetchAllUsers());
	}

	/**
	 * @param id
	 * @return user details of the passed id
	 * @throws UserNotFoundException 
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Optional<User>> fetchById(@PathVariable int id) throws UserNotFoundException {
		return ResponseEntity.ok(userService.fetchUserByid(id));
	}

}
