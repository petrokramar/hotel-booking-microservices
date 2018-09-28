package com.hotelbooking.service;

import com.hotelbooking.entity.Room;
import com.hotelbooking.entity.dto.RoomListDTO;
import com.hotelbooking.entity.request.RoomRequest;

import java.util.Date;
import java.util.List;

public interface RoomService {

    List<Room> getAllRooms();

    RoomListDTO getAllHotelRooms(int hotelId, int page, int size);

    RoomListDTO getAllHotelFreeRooms(int hotelId, Date checkIn, Date checkOut, int page, int size);

    Room getRoom(int id);

    boolean checkRoomIsFree(int id, Date checkIn, Date checkOut);

    Room saveRoom(RoomRequest country);
}
