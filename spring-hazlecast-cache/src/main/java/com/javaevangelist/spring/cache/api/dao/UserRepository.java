package com.javaevangelist.spring.cache.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaevangelist.spring.cache.api.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

}