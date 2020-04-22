package com.example.demo.web.rest;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserResource {

    private static final String ENTITY_NAME = "user";

    private final Logger log = LoggerFactory.getLogger(UserService.class);
    
    private final UserService userService;

    public UserResource(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<Page<UserDTO>> findAllByUsers(Pageable pageable) {
        log.debug("User controller -> ", ENTITY_NAME);
        Page<UserDTO> response = this.userService.findAllByUsers(pageable);
        return ResponseEntity.ok().body(response);
    }

}