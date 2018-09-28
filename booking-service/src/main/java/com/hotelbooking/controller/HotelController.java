package com.hotelbooking.controller;

import com.hotelbooking.entity.Hotel;
import com.hotelbooking.entity.dto.HotelListDTO;
import com.hotelbooking.entity.request.HotelRequest;
import com.hotelbooking.service.HotelService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/hotels", produces = "application/json")
public class HotelController {

    private HotelService service;

    @GetMapping()
    public ResponseEntity<List<Hotel>> getHotels() {
        List<Hotel> hotels = service.getAllHotels();
        return ResponseEntity.ok(hotels);
    }

    @GetMapping(params = {"filter", "sortOrder", "page", "size"})
    public ResponseEntity<HotelListDTO> getHotelsPage(@RequestParam("filter") String filter,
                                                      @RequestParam("sortOrder") String sortOrder,
                                                      @RequestParam("page") int page,
                                                      @RequestParam("size") int size) {
        HotelListDTO hotels = service.getHotelsPage(filter, sortOrder, page, size);
        return ResponseEntity.ok(hotels);
    }

    @GetMapping(params = {"cityId", "checkIn", "checkOut", "page", "size"})
    public ResponseEntity<HotelListDTO> getHotelsWithFreeRoomsPage(@RequestParam("cityId") int cityId,
                                       @RequestParam("checkIn") @DateTimeFormat(pattern = "yyyy-MM-dd") Date checkIn,
                                       @RequestParam("checkOut") @DateTimeFormat(pattern = "yyyy-MM-dd") Date checkOut,
                                       @RequestParam("page") int page,
                                       @RequestParam("size") int size) {
        HotelListDTO hotels = service.getHotelsWithFreeRoomsPage(cityId, checkIn, checkOut, page, size);
        return ResponseEntity.ok(hotels);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Hotel> saveHotel(@Valid @RequestBody HotelRequest request) {
        Hotel hotel = service.saveHotel(request);
        return ResponseEntity.ok(hotel);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Hotel> getHotel(@PathVariable int id) {
        Hotel hotel = service.getHotel(id);
        return ResponseEntity.ok(hotel);
    }
}