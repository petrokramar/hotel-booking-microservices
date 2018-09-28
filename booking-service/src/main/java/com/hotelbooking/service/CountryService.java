package com.hotelbooking.service;

import com.hotelbooking.entity.Country;
import com.hotelbooking.entity.dto.CountryListDTO;
import com.hotelbooking.entity.request.CountryRequest;

import java.util.List;

public interface CountryService {

    List<Country> getAllCountries();

    CountryListDTO getCountriesPage(String filter, String sortOrder, int page, int size);

    Long countAllCountries();

    Country getCountry(int id);

    Country saveCountry(CountryRequest country);
}
