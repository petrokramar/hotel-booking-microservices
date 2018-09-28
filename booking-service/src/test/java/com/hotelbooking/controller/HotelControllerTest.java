package com.hotelbooking.controller;

import com.hotelbooking.config.SecurityConfig;
import com.hotelbooking.entity.City;
import com.hotelbooking.entity.Country;
import com.hotelbooking.entity.Hotel;
import com.hotelbooking.entity.HotelCategory;
import com.hotelbooking.entity.request.HotelRequest;
import com.hotelbooking.service.HotelService;
import net.javacrumbs.jsonunit.core.Option;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.inject.Inject;

import java.util.ArrayList;
import java.util.List;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HotelController.class)
@Import(SecurityConfig.class)
public class HotelControllerTest{

    private final String HOTELS_URL = "/api/hotels";
    private final int HOTEL_ONE_ID = 1;
    private final int HOTEL_TWO_ID = 2;
    private final int HOTEL_THREE_ID = 3;
    private final int COUNTRY_ID = 4;
    private final int CITY_ID = 5;

    @MockBean
    private HotelService service;

    @Inject
    private MockMvc mockMvc;

    @Test
    public void getAllHotels() throws Exception {

        // given
        Country country = new Country(COUNTRY_ID, "Country name");
        City city = new City(CITY_ID, "City name", country);
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(new Hotel(HOTEL_ONE_ID, "Hotel one name", city, HotelCategory.THREE_STARS));
        hotels.add(new Hotel(HOTEL_TWO_ID, "Hotel two name",  city, HotelCategory.FOUR_STARS));
        hotels.add(new Hotel(HOTEL_THREE_ID, "Hotel three name", city, HotelCategory.FIVE_STARS));
        given(service.getAllHotels()).willReturn(hotels);

        // when
        String result = mockMvc.perform(get(HOTELS_URL)
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        // then
        assertThatJson(result).when(Option.IGNORING_ARRAY_ORDER).isEqualTo(hotels);
        verify(service).getAllHotels();
        verifyNoMoreInteractions(service);
    }

    @Test
    public void saveHotel() throws Exception {

        // given
        Country country = new Country(COUNTRY_ID, "Country name");
        City city = new City(CITY_ID, "City name", country);
        Hotel hotel = new Hotel(HOTEL_ONE_ID, "Hotel name", city, HotelCategory.THREE_STARS);
        HotelRequest request = new HotelRequest(HOTEL_ONE_ID, "Hotel name", CITY_ID,
                HotelCategory.THREE_STARS.name());
        given(service.saveHotel(request)).willReturn(hotel);
        String requestJson = "{\"id\":\"1\",\"name\":\"Hotel name\",\"cityId\":\"5\",\"category\":\"THREE_STARS\"}";

        // when
        String result = mockMvc.perform(post(HOTELS_URL)
                .content(requestJson)
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andReturn().getResponse().getContentAsString();

        // then
        assertThatJson(result).when(Option.IGNORING_ARRAY_ORDER).isEqualTo(hotel);
        verify(service).saveHotel(request);
        verifyNoMoreInteractions(service);
    }

    @Test
    public void getHotel() throws Exception {

        // given
        Country country = new Country(COUNTRY_ID, "Country name");
        City city = new City(CITY_ID, "City name", country);
        Hotel hotel = new Hotel(HOTEL_ONE_ID, "Hotel name", city, HotelCategory.THREE_STARS);
        given(service.getHotel(HOTEL_ONE_ID)).willReturn(hotel);

        // when
        String result = mockMvc.perform(get(HOTELS_URL.concat("/").concat("1"))
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        // then
        assertThatJson(result).when(Option.IGNORING_ARRAY_ORDER).isEqualTo(hotel);
        verify(service).getHotel(HOTEL_ONE_ID);
        verifyNoMoreInteractions(service);
    }
}