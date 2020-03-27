package com.sandeep.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.sandeep.redis.model.User;
import com.sandeep.redis.repository.UserRepository;

@SpringBootApplication
@EnableCaching
public class RedisCachePocApplication implements CommandLineRunner{

	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Autowired
	UserRepository userRepository; 
	
	public static void main(String[] args) {
		SpringApplication.run(RedisCachePocApplication.class, args);
	}

	
	
	@Override
	public void run(String... args) throws Exception {
		LOG.info("Saving users. Current user count is {}.", userRepository.count());
		User sandeep = new User("Sandeep", 50000L);
		User sandeep1 = new User("Sandeep1", 5044000L);
		User sandeep2 = new User("Sandeep2", 5033000L);
		
		userRepository.save(sandeep);
		userRepository.save(sandeep1);
		userRepository.save(sandeep2);
		LOG.info("Done saving users. Data: {}.", userRepository.findAll());
	}

}
