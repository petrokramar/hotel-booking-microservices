package com.hotelbooking.service;

import com.hotelbooking.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUser(String username);
}
