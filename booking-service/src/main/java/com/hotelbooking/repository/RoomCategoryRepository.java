package com.hotelbooking.repository;

import com.hotelbooking.entity.RoomCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomCategoryRepository extends CrudRepository<RoomCategory, Integer> {

    List<RoomCategory> findAllByOrderByName();
}
