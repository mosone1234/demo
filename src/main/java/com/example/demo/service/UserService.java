package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.respository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final String ENTITY_NAME = "user";

    private final Logger log = LoggerFactory.getLogger(UserService.class);
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Page<UserDTO> findAllByUsers(Pageable pageable) {
        log.debug("List all users -> ", ENTITY_NAME);
        Page<UserDTO> response = this.userRepository.findAll(pageable).map(UserDTO::new);
        return response;
    }

}