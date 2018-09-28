package com.hotelbooking.service;

import com.hotelbooking.entity.RoomCategory;
import com.hotelbooking.entity.request.RoomCategoryRequest;

import java.util.List;

public interface RoomCategoryService {

    List<RoomCategory> getAllRoomCategories();

    RoomCategory getRoomCategory(int id);

    RoomCategory saveRoomCategory(RoomCategoryRequest country);
}
