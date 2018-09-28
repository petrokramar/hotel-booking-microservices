package com.hotelbooking.controller;

import com.hotelbooking.entity.City;
import com.hotelbooking.entity.dto.CityListDTO;
import com.hotelbooking.entity.request.CityRequest;
import com.hotelbooking.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/cities", produces = "application/json")
public class CityController {

    private CityService service;

    @GetMapping()
    public ResponseEntity<List<City>> getAllCities() {
        List<City> countries = service.getAllCities();
        return ResponseEntity.ok(countries);
    }

    @GetMapping(params = {"filter", "sortOrder", "page", "size"})
    public ResponseEntity<CityListDTO> getCitiesPage(@RequestParam( "filter" ) String filter,
                                                     @RequestParam( "sortOrder" ) String sortOrder,
                                                     @RequestParam( "page" ) int page,
                                                     @RequestParam( "size" ) int size) {
        CityListDTO cities = service.getCitiesPage(filter, sortOrder, page, size);
        return ResponseEntity.ok(cities);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<City> saveCity(@Valid @RequestBody CityRequest request) {
        City city = service.saveCity(request);
        return ResponseEntity.ok(city);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<City> getCity(@PathVariable int id) {
        City city = service.getCity(id);
        return ResponseEntity.ok(city);
    }
}