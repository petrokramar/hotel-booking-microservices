package com.hotelbooking.service.impl;

import com.hotelbooking.entity.Hotel;
import com.hotelbooking.entity.Room;
import com.hotelbooking.entity.RoomCategory;
import com.hotelbooking.entity.dto.RoomListDTO;
import com.hotelbooking.entity.request.RoomRequest;
import com.hotelbooking.exceptions.DataNotFoundException;
import com.hotelbooking.repository.HotelRepository;
import com.hotelbooking.repository.RoomCategoryRepository;
import com.hotelbooking.repository.RoomRepository;
import com.hotelbooking.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class RoomServiceImpl implements RoomService{

    private RoomRepository repository;
    private HotelRepository hotelRepository;
    private RoomCategoryRepository roomCategoryRepository;

    @Override
    public List<Room> getAllRooms() {
        List<Room> rooms = (List<Room>) repository.findAll();
        return rooms;
    }

    @Override
    public RoomListDTO getAllHotelRooms(int hotelId, int page, int size) {
        Page<Room> resultPage = repository.findHotelRoomsPage(hotelId, PageRequest.of(page, size));
        resultPage.getTotalElements();
        List<Room> rooms = resultPage.getContent();
        long totalElements = resultPage.getTotalElements();
        return new RoomListDTO(rooms, totalElements);
    }

    @Override
    public RoomListDTO getAllHotelFreeRooms(int hotelId, Date checkIn, Date checkOut, int page, int size) {
        Page<Room> resultPage = repository.findHotelFreeRoomsPage(hotelId, checkIn, checkOut,
                PageRequest.of(page, size));
        resultPage.getTotalElements();
        List<Room> rooms = resultPage.getContent();
        long totalElements = resultPage.getTotalElements();
        return new RoomListDTO(rooms, totalElements);
    }

    @Override
    public Room getRoom(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(String.format("Room id= %s not found", id)));
    }

    @Override
    public boolean checkRoomIsFree(int id, Date checkIn, Date checkOut) {
        return repository.checkRoomIsFree(id, checkIn, checkOut);
    }

    @Override
    public Room saveRoom(RoomRequest request) {
        int hotelId = request.getHotelId();
        int roomCategoryId = request.getRoomCategoryId();
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new DataNotFoundException(String.format("Hotel id= %s not found", hotelId)));
        RoomCategory roomCategory = roomCategoryRepository.findById(roomCategoryId).orElseThrow(() ->
                new DataNotFoundException(String.format("Room category id= %s not found", roomCategoryId)));
        Room room = new Room(request.getId(), request.getNumber(), hotel, roomCategory, request.getPrice(),
                request.getPersons());
        return repository.save(room);
    }
}
