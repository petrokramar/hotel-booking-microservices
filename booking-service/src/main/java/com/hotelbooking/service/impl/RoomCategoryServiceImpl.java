package com.hotelbooking.service.impl;

import com.hotelbooking.entity.RoomCategory;
import com.hotelbooking.entity.request.RoomCategoryRequest;
import com.hotelbooking.exceptions.DataNotFoundException;
import com.hotelbooking.repository.RoomCategoryRepository;
import com.hotelbooking.service.RoomCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class RoomCategoryServiceImpl implements RoomCategoryService {

    private RoomCategoryRepository repository;

    @Override
    public List<RoomCategory> getAllRoomCategories() {
        return repository.findAllByOrderByName();
    }

    @Override
    public RoomCategory getRoomCategory(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(String.format("Room category id= %s not found", id)));
    }

    @Override
    public RoomCategory saveRoomCategory(RoomCategoryRequest request) {
        RoomCategory roomCategory = new RoomCategory(request.getId(), request.getName(), request.getDescription());
        return repository.save(roomCategory);
    }
}