package com.hotelbooking.demo.repository;

import com.hotelbooking.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

	User findOneByUsername(String username);

	User findByActivationCode(String code);
}