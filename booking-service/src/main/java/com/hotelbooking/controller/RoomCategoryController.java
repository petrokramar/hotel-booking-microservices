package com.hotelbooking.controller;

import com.hotelbooking.entity.RoomCategory;
import com.hotelbooking.entity.request.RoomCategoryRequest;
import com.hotelbooking.service.RoomCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/roomCategories", produces = "application/json")
public class RoomCategoryController {

    private RoomCategoryService service;

    @GetMapping()
    public ResponseEntity<List<RoomCategory>> getAllRoomCategories() {
        List<RoomCategory> roomCategories = service.getAllRoomCategories();
        return ResponseEntity.ok(roomCategories);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<RoomCategory> saveRoomCategory(@Valid @RequestBody RoomCategoryRequest request) {
        RoomCategory roomCategory = service.saveRoomCategory(request);
        return ResponseEntity.ok(roomCategory);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RoomCategory> getRoomCategory(@PathVariable int id) {
        RoomCategory roomCategory = service.getRoomCategory(id);
        return ResponseEntity.ok(roomCategory);
    }
}