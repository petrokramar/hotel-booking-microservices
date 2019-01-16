package com.hotelbooking.demo.controller;

import com.hotelbooking.demo.model.dto.UserRegistrationDto;
import com.hotelbooking.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class RegistrationController {

    private UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<?> create(@RequestBody @Valid UserRegistrationDto user) {
        userService.register(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}