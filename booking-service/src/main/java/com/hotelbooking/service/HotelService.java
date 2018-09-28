package com.hotelbooking.service;

import com.hotelbooking.entity.Hotel;
import com.hotelbooking.entity.dto.HotelListDTO;
import com.hotelbooking.entity.request.HotelRequest;

import java.util.Date;
import java.util.List;

public interface HotelService {

    List<Hotel> getAllHotels();

    HotelListDTO getHotelsPage(String filter, String sortOrder, int page, int size);

    HotelListDTO getHotelsWithFreeRoomsPage(int cityId, Date checkIn, Date checkOut, int page, int size);

    Hotel getHotel(int id);

    Hotel saveHotel(HotelRequest hotel);

}
