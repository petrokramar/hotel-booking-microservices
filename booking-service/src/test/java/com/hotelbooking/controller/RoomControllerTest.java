package com.hotelbooking.controller;

import com.hotelbooking.config.SecurityConfig;
import com.hotelbooking.entity.*;
import com.hotelbooking.entity.request.RoomRequest;
import com.hotelbooking.service.RoomService;
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
@WebMvcTest(RoomController.class)
@Import(SecurityConfig.class)
public class RoomControllerTest{

    private final String ROOMS_URL = "/api/rooms";
    private final int ROOM_ONE_ID = 1;
    private final int ROOM_TWO_ID = 2;
    private final int ROOM_THREE_ID = 3;
    private final int COUNTRY_ID = 4;
    private final int CITY_ID = 5;
    private final int HOTEL_ID = 6;
    private final int ROOM_CATEGORY_ID = 7;
    private final int ROOM_ONE_NUMBER = 33;
    private final int ROOM_ONE_PRICE = 10000;
    private final int ROOM_ONE_PERSONS = 2;
    private final int ROOM_TWO_NUMBER = 44;
    private final int ROOM_TWO_PRICE = 20000;
    private final int ROOM_TWO_PERSONS = 3;
    private final int ROOM_THREE_NUMBER = 55;
    private final int ROOM_THREE_PRICE = 30000;
    private final int ROOM_THREE_PERSONS = 4;


    @MockBean
    private RoomService service;

    @Inject
    private MockMvc mockMvc;

    @Test
    public void getAllRooms() throws Exception {

        // given
        Country country = new Country(COUNTRY_ID, "Country name");
        City city = new City(CITY_ID, "City name", country);
        Hotel hotel =  new Hotel(HOTEL_ID, "Hotel name", city, HotelCategory.THREE_STARS);
        RoomCategory roomCategory = new RoomCategory(ROOM_CATEGORY_ID, "Room category name",
                "Room category description" );
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room(ROOM_ONE_ID, ROOM_ONE_NUMBER, hotel, roomCategory, ROOM_ONE_PRICE, ROOM_ONE_PERSONS));
        rooms.add(new Room(ROOM_TWO_ID, ROOM_TWO_NUMBER, hotel, roomCategory, ROOM_TWO_PRICE, ROOM_TWO_PERSONS));
        rooms.add(new Room(ROOM_THREE_ID, ROOM_THREE_NUMBER, hotel, roomCategory, ROOM_THREE_PRICE, ROOM_THREE_PERSONS));
        given(service.getAllRooms()).willReturn(rooms);

        // when
        String result = mockMvc.perform(get(ROOMS_URL)
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        // then
        assertThatJson(result).when(Option.IGNORING_ARRAY_ORDER).isEqualTo(rooms);
        verify(service).getAllRooms();
        verifyNoMoreInteractions(service);
    }

    @Test
    public void saveRoom() throws Exception {

        // given
        Country country = new Country(COUNTRY_ID, "Country name");
        City city = new City(CITY_ID, "City name", country);
        Hotel hotel = new Hotel(HOTEL_ID, "Hotel name", city, HotelCategory.THREE_STARS);
        RoomCategory roomCategory = new RoomCategory(ROOM_CATEGORY_ID, "Room category name",
                "Room category description" );
        Room room = new Room(ROOM_ONE_ID, ROOM_ONE_NUMBER, hotel, roomCategory, ROOM_ONE_PRICE, ROOM_ONE_PERSONS);
        RoomRequest request = new RoomRequest(ROOM_ONE_ID, ROOM_ONE_NUMBER, HOTEL_ID, ROOM_CATEGORY_ID, ROOM_ONE_PRICE,
                ROOM_ONE_PERSONS);
        given(service.saveRoom(request)).willReturn(room);
        String requestJson = "{\"id\":\"1\",\"number\":\"33\",\"hotelId\":\"6\",\"roomCategoryId\":\"7\"," +
                "\"price\":\"10000\",\"persons\":\"2\"}";

        // when
        String result = mockMvc.perform(post(ROOMS_URL)
                .content(requestJson)
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andReturn().getResponse().getContentAsString();

        // then
        assertThatJson(result).when(Option.IGNORING_ARRAY_ORDER).isEqualTo(room);
        verify(service).saveRoom(request);
        verifyNoMoreInteractions(service);
    }

    @Test
    public void getRoom() throws Exception {

        // given
        Country country = new Country(COUNTRY_ID, "Country name");
        City city = new City(CITY_ID, "City name", country);
        Hotel hotel = new Hotel(HOTEL_ID, "Hotel name", city, HotelCategory.THREE_STARS);
        RoomCategory roomCategory = new RoomCategory(ROOM_CATEGORY_ID, "Room category name",
                "Room category description" );
        Room room = new Room(ROOM_ONE_ID, ROOM_ONE_NUMBER, hotel, roomCategory, ROOM_ONE_PRICE, ROOM_ONE_PERSONS);
        given(service.getRoom(ROOM_ONE_ID)).willReturn(room);

        // when
        String result = mockMvc.perform(get(ROOMS_URL.concat("/").concat("1"))
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        // then
        assertThatJson(result).when(Option.IGNORING_ARRAY_ORDER).isEqualTo(room);
        verify(service).getRoom(ROOM_ONE_ID);
        verifyNoMoreInteractions(service);
    }
}