package com.example.demo;

import com.example.demo.domain.User;
import com.example.demo.respository.UserRepository;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	UserRepository userRepository;

	public static void main(final String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public InitializingBean sendDatabase() {
		return () -> {
			User user = new User();
			user.setLogin("admin");
			user.setFirstName("admin");
			user.setLastName("admin");
			user.setEmail("admin@localhost.com");
			user.setPassword("12345");
			userRepository.save(user);
		};
	}

}
