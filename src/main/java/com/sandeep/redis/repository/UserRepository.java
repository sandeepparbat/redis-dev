package com.sandeep.redis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sandeep.redis.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
