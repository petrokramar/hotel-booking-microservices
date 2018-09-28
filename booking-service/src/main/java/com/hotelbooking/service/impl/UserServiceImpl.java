package com.hotelbooking.service.impl;

import com.hotelbooking.entity.User;
import com.hotelbooking.exceptions.DataNotFoundException;
import com.hotelbooking.repository.UserRepository;
import com.hotelbooking.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private UserRepository repository;

    @Override
    public List<User> getAllUsers() {
        List<User> users = (List<User>) repository.findAll();
        return users;
    }

    @Override
    public User getUser(String username) {
        return repository.findById(username)
                .orElseThrow(() -> new DataNotFoundException(String.format("User username= %s not found", username)));
    }
}
