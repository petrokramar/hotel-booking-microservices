package com.hotelbooking.entity.dto;

import com.hotelbooking.entity.Hotel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class HotelListDTO {
    private List<Hotel> hotels;
    private long totalElements;
}
