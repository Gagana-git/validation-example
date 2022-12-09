package com.example.validationexample.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.validationexample.dto.UserDto;
import com.example.validationexample.entities.User;
import com.example.validationexample.exceptions.UserNotFoundException;
import com.example.validationexample.repositories.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo repo;

	/**
	 * @param userDto
	 * @return saved user to db
	 */
	public User saveUser(UserDto userDto) {
		User user = User.build(0, userDto.getName(), userDto.getEmail(), userDto.getMobile(), userDto.getGender(), userDto.getAge(),
				userDto.getNationality());
		return repo.save(user);

	}

	/**
	 * @return all users from user table
	 */
	public List<User> fetchAllUsers() {
		return repo.findAll();
	}

	/**
	 * @param id
	 * @return return  user object for the id passed if present, null otherwise
	 * @throws UserNotFoundException 
	 */
	public Optional<User> fetchUserByid(int id) throws UserNotFoundException {
		
		return Optional.ofNullable(repo.findById(id).orElseThrow(()-> new UserNotFoundException("User not avalilable with id"+ id)));	

	}

}
