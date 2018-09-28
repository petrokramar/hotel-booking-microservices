package com.hotelbooking.repository;

import com.hotelbooking.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
