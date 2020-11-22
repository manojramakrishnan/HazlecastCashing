package com.javaevangelist.spring.cache.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.javaevangelist.spring.cache.api.dao.UserRepository;
import com.javaevangelist.spring.cache.api.model.Users;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	@Cacheable(cacheNames = { "userCache" })
	public List<Users> getUsers() {
		System.out.println("Hit DB 1st time in getUsers()");
		return repository.findAll();
	}

	@Cacheable(value = "userCache", key = "#id", unless = "#result==null")
	public Users getUser(int id) {
		System.out.println("Hit DB 1st time in getUser()");
		return repository.findOne(id);
	}

	@CacheEvict(value = "userCache")
	public String delete(int id) {
		repository.delete(id);
		return "User deleted with id " + id;
	}

}