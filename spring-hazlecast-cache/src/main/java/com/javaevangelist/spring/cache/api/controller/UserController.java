package com.javaevangelist.spring.cache.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaevangelist.spring.cache.api.model.Users;
import com.javaevangelist.spring.cache.api.service.UserService;

@RestController
@RequestMapping("/cache-api")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("/getAllUsers")
	public List<Users> getAllUsers() {
		return service.getUsers();
	}

	@GetMapping("/getUserById/{id}")
	public Users getUser(@PathVariable int id) {
		return service.getUser(id);
	}

	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable int id) {
		return service.delete(id);
	}

}