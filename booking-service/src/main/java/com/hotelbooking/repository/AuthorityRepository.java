package com.hotelbooking.repository;

import com.hotelbooking.entity.Authority;
import com.hotelbooking.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface AuthorityRepository extends CrudRepository<Authority, Integer> {
}
