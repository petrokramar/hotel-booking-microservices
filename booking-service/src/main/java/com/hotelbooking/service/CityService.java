package com.hotelbooking.service;

import com.hotelbooking.entity.City;
import com.hotelbooking.entity.dto.CityListDTO;
import com.hotelbooking.entity.request.CityRequest;

import java.util.List;

public interface CityService {

    List<City> getAllCities();

    CityListDTO getCitiesPage(String filter, String sortOrder, int page, int size);

    City getCity(int id);

    City saveCity(CityRequest city);
}
