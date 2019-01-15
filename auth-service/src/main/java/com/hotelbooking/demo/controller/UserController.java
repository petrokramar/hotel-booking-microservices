package com.hotelbooking.demo.controller;

import com.hotelbooking.demo.model.User;
import com.hotelbooking.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/v1/users", produces = "application/json")
public class UserController {

    UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<?> create(@RequestBody @Valid User user) {
        userService.register(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}