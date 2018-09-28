package com.hotelbooking.entity.dto;

import com.hotelbooking.entity.City;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class CityListDTO {
    private List<City> cities;
    private long totalElements;
}
