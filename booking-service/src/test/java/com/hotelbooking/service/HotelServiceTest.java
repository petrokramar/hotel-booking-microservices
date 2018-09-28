package com.hotelbooking.service;

import com.hotelbooking.entity.City;
import com.hotelbooking.entity.Country;
import com.hotelbooking.entity.Hotel;
import com.hotelbooking.entity.HotelCategory;
import com.hotelbooking.entity.request.HotelRequest;
import com.hotelbooking.exceptions.DataNotFoundException;
import com.hotelbooking.repository.CityRepository;
import com.hotelbooking.repository.HotelRepository;
import com.hotelbooking.service.impl.HotelServiceImpl;
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

public class HotelServiceTest {

    private final int HOTEL_ONE_ID = 1;
    private final int HOTEL_TWO_ID = 2;
    private final int HOTEL_THREE_ID = 3;
    private final int COUNTRY_ID = 4;
    private final int CITY_ID = 5;
    private HotelRepository repository;
    private CityRepository cityRepository;
    private HotelService service;

    @Before
    public void setUp() {
        cityRepository = mock(CityRepository.class);
        repository = mock(HotelRepository.class);
        service = new HotelServiceImpl(repository, cityRepository);
    }

    @Test
    public void getAllHotels() {

        // given
        Country country = new Country(COUNTRY_ID, "Country name");
        City city = new City(CITY_ID, "City name", country);

        List<Hotel> expectedHotels = new ArrayList<>();
        Hotel hotelOne = new Hotel(HOTEL_ONE_ID, "Hotel name 1", city, HotelCategory.THREE_STARS);
        expectedHotels.add(hotelOne);
        Hotel hotelTwo = new Hotel(HOTEL_TWO_ID, "Hotel name 2", city, HotelCategory.FOUR_STARS);
        expectedHotels.add(hotelTwo);
        Hotel hotelThree = new Hotel(HOTEL_THREE_ID, "Hotel name 3", city, HotelCategory.FIVE_STARS);
        expectedHotels.add(hotelThree);
        given(repository.findAll()).willReturn(expectedHotels);

        //when
        List<Hotel> actualHotels = service.getAllHotels();

        //then
        assertEquals(expectedHotels, actualHotels);
        verify(repository).findAll();
        verifyNoMoreInteractions(repository);
    }

    @Test
    public void getHotel() {

        // given
        Country country = new Country(COUNTRY_ID, "Country name");
        City city = new City(CITY_ID, "City name", country);
        Hotel expectedHotel = new Hotel(HOTEL_ONE_ID, "Hotel name", city, HotelCategory.FIVE_STARS);
        given(repository.findOne(HOTEL_ONE_ID)).willReturn(expectedHotel);

        //when
        Hotel actualHotel = service.getHotel(HOTEL_ONE_ID);

        //then
        assertEquals(expectedHotel, actualHotel);
        verify(repository).findOne(HOTEL_ONE_ID);
        verifyNoMoreInteractions(repository);
    }

    @Test(expected = DataNotFoundException.class)
    public void getHotelNotFound() {

        // given
        given(repository.findOne(HOTEL_ONE_ID)).willReturn(null);

        //when
        Hotel hotel = service.getHotel(HOTEL_ONE_ID);

        fail();
    }

    @Test
    public void saveHotel() {

        // given
        HotelRequest request = new HotelRequest(HOTEL_ONE_ID, "Hotel name", CITY_ID,"FIVE_STARS");
        Country country = new Country(COUNTRY_ID, "Country name");
        City city = new City(CITY_ID, "City name", country);
        Hotel expectedHotel = new Hotel(HOTEL_ONE_ID, "Hotel name", city, HotelCategory.FIVE_STARS);
        given(cityRepository.findOne(CITY_ID)).willReturn(city);
        given(repository.save(expectedHotel)).willReturn(expectedHotel);

        //when
        Hotel actualHotel = service.saveHotel(request);

        //then
        assertEquals(expectedHotel, actualHotel);
        verify(cityRepository).findOne(CITY_ID);
        verifyNoMoreInteractions(cityRepository);
        verify(repository).save(expectedHotel);
        verifyNoMoreInteractions(repository);
    }
}