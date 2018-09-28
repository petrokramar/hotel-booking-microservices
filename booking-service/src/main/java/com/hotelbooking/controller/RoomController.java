package com.hotelbooking.controller;

import com.hotelbooking.entity.Room;
import com.hotelbooking.entity.dto.RoomListDTO;
import com.hotelbooking.entity.request.RoomRequest;
import com.hotelbooking.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/rooms", produces = "application/json")
public class RoomController {

    private RoomService service;

    @GetMapping()
    public ResponseEntity<List<Room>> getRooms() {
        List<Room> rooms = service.getAllRooms();
        return ResponseEntity.ok(rooms);
    }

    @GetMapping(params = {"hotelId", "page", "size"})
    public ResponseEntity<RoomListDTO> getHotelRooms(@RequestParam( "hotelId" ) int hotelId,
                                                     @RequestParam( "page" ) int page,
                                                     @RequestParam( "size" ) int size) {
        RoomListDTO rooms = service.getAllHotelRooms(hotelId, page, size);
        return ResponseEntity.ok(rooms);
    }

    @GetMapping(params = {"hotelId", "checkIn", "checkOut", "page", "size" })
    public ResponseEntity<RoomListDTO> getHotelFreeRooms(
            @RequestParam( "hotelId" ) int hotelId,
            @RequestParam( "checkIn" ) @DateTimeFormat(pattern="yyyy-MM-dd") Date checkIn,
            @RequestParam( "checkOut" ) @DateTimeFormat(pattern="yyyy-MM-dd") Date checkOut,
            @RequestParam( "page" ) int page,
            @RequestParam( "size" ) int size)
    {
        RoomListDTO rooms = service.getAllHotelFreeRooms(hotelId, checkIn, checkOut, page, size);
        return ResponseEntity.ok(rooms);
    }

    @GetMapping(value = "/{id}", params = {"checkIn", "checkOut" })
    public ResponseEntity<Boolean> checkRoomIsFree(
            @PathVariable int id,
            @RequestParam( "checkIn" ) @DateTimeFormat(pattern="yyyy-MM-dd") Date checkIn,
            @RequestParam( "checkOut" ) @DateTimeFormat(pattern="yyyy-MM-dd") Date checkOut)
    {
        Boolean roomIsFree= service.checkRoomIsFree(id, checkIn, checkOut);
        return ResponseEntity.ok(roomIsFree);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Room> saveRoom(@Valid @RequestBody RoomRequest request) {
        Room room = service.saveRoom(request);
        return ResponseEntity.ok(room);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Room> getRoomCategory(@PathVariable int id) {
        Room room = service.getRoom(id);
        return ResponseEntity.ok(room);
    }

}
