package com.sandeep.redis.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sandeep.redis.model.User;
import com.sandeep.redis.repository.UserRepository;

@RestController
public class UserController {
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Autowired
	UserRepository userRepository;
	
	@Cacheable(key="#userId", value="user",unless="#result.followers < 12000")
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public Optional<User> getUser(@PathVariable String userId) {
	  LOG.info("Getting user with ID {}.", userId);
	  return userRepository.findById(Long.valueOf(userId));
	}
}
