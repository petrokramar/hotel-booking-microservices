package com.hotelbooking.service;

import com.hotelbooking.entity.City;
import com.hotelbooking.entity.Country;
import com.hotelbooking.entity.request.CityRequest;
import com.hotelbooking.exceptions.DataNotFoundException;
import com.hotelbooking.repository.CityRepository;
import com.hotelbooking.repository.CountryRepository;
import com.hotelbooking.service.impl.CityServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class CityServiceTest {

    private final int CITY_ONE_ID = 1;
    private final int CITY_TWO_ID = 2;
    private final int CITY_THREE_ID = 3;
    private final int COUNTRY_ID = 4;
    private CountryRepository countryRepository;
    private CityRepository repository;
    private CityService service;

    @Before
    public void setUp() {
        countryRepository = mock(CountryRepository.class);
        repository = mock(CityRepository.class);
        service = new CityServiceImpl(repository, countryRepository);
    }

    @Test
    public void getAllCities() {

        // given
        Country country = new Country(COUNTRY_ID, "Country name");
        List<City> expectedCities = new ArrayList<>();
        City cityOne = new City(CITY_ONE_ID, "City one name", country);
        expectedCities.add(cityOne);
        City cityTwo = new City(CITY_TWO_ID, "City two name", country);
        expectedCities.add(cityTwo);
        City cityThree = new City(CITY_THREE_ID, "City three name", country);
        expectedCities.add(cityThree);
        given(repository.findAllByOrderByName()).willReturn(expectedCities);

        //when
        List<City> actualCities = service.getAllCities();

        //then
        assertEquals(expectedCities, actualCities);
        verify(repository).findAllByOrderByName();
        verifyNoMoreInteractions(repository);
    }

    @Test
    public void getCity() {

        // given
        Country country = new Country(COUNTRY_ID, "Country name");
        City expectedCity = new City(CITY_ONE_ID, "City name", country);
        given(repository.findOne(CITY_ONE_ID)).willReturn(expectedCity);

        //when
        City actualCity = service.getCity(CITY_ONE_ID);

        //then
        assertEquals(expectedCity, actualCity);
        verify(repository).findOne(CITY_ONE_ID);
        verifyNoMoreInteractions(repository);
    }

    @Test(expected = DataNotFoundException.class)
    public void getCityNotFound() {

        // given
        given(repository.findOne(CITY_ONE_ID)).willReturn(null);

        //when
        City city = service.getCity(CITY_ONE_ID);

        fail();
    }

    @Test
    public void saveCity() {

        // given
        CityRequest request = new CityRequest(CITY_ONE_ID, "City name", COUNTRY_ID);
        Country country = new Country(COUNTRY_ID, "Country name");
        City expectedCity = new City(CITY_ONE_ID, "City name", country);
        given(countryRepository.findOne(COUNTRY_ID)).willReturn(country);
        given(repository.save(expectedCity)).willReturn(expectedCity);

        //when
        City actualCity = service.saveCity(request);

        //then
        assertEquals(expectedCity, actualCity);
        verify(countryRepository).findOne(COUNTRY_ID);
        verifyNoMoreInteractions(countryRepository);
        verify(repository).save(expectedCity);
        verifyNoMoreInteractions(repository);
    }
}