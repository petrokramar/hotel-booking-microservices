package com.hotelbooking.controller;

import com.hotelbooking.config.SecurityConfig;
import com.hotelbooking.entity.*;
import com.hotelbooking.entity.request.BookingRequest;
import com.hotelbooking.service.BookingService;
import net.javacrumbs.jsonunit.core.Option;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.inject.Inject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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
@WebMvcTest(BookingController.class)
@Import(SecurityConfig.class)
public class BookingControllerTest {

    private final String BOOKING_URL = "/api/booking";
    private final int BOOKING_ONE_ID = 1;
    private final int COUNTRY_ID = 2;
    private final int CITY_ID = 3;
    private final int HOTEL_ID = 4;
    private final int ROOM_ID = 5;
    private final int ROOM_CATEGORY_ID = 6;
    private final int ROLE_ID = 7;
    private final int ROOM_ONE_NUMBER = 11;
    private final int ROOM_ONE_PRICE = 10000;
    private final int ROOM_ONE_NUMBER_OF_PERSONS = 2;
    private final boolean USER_ENABLED = true;
    private final int BOOKING_ONE_TOTAL_SUM = 10000;
    private final int BOOKING_ONE_NUMBER_OF_PERSONS = 2;

    @MockBean
    private BookingService service;

    @Inject
    private MockMvc mockMvc;

    @Test
    public void getAllBooking() throws Exception {

        // given
        Country country = new Country(COUNTRY_ID, "Country name");
        City city = new City(CITY_ID, "City name", country);
        Hotel hotel = new Hotel(HOTEL_ID, "Hotel name", city, HotelCategory.FIVE_STARS);
        RoomCategory roomCategory = new RoomCategory(ROOM_CATEGORY_ID, "Room category name",
                "Room category description" );

        Set<Authority> rolesUserOne = new HashSet<>();
        Authority roleOne = new Authority(ROLE_ID, "username", "ROLE_ADMIN");
        rolesUserOne.add(roleOne);
        User userOne = new User("username", "password", USER_ENABLED,
                "First name","Last name", rolesUserOne);
        Room roomOne = new Room(ROOM_ID, ROOM_ONE_NUMBER, hotel, roomCategory, ROOM_ONE_PRICE,
                ROOM_ONE_NUMBER_OF_PERSONS);

        List<Booking> booking = new ArrayList<>();
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date dateBegin = format.parse("01-04-2018");
        Date dateEnd = format.parse("10-04-2018");
        Booking bookingOne = new Booking(BOOKING_ONE_ID, roomOne, userOne, BOOKING_ONE_TOTAL_SUM,
                BOOKING_ONE_NUMBER_OF_PERSONS, dateBegin, dateEnd);
        booking.add(bookingOne);
        given(service.getAllBooking()).willReturn(booking);

        // when
        String result = mockMvc.perform(get(BOOKING_URL)
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        // then
        assertThatJson(result).when(Option.IGNORING_ARRAY_ORDER).isEqualTo(booking);
        verify(service).getAllBooking();
        verifyNoMoreInteractions(service);
    }

    @Test
    public void saveBooking() throws Exception {

        // given
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date dateBegin = format.parse("2018-04-01");
        Date dateEnd = format.parse("2018-04-10");
        BookingRequest request = new BookingRequest(BOOKING_ONE_ID, ROOM_ID, "username", BOOKING_ONE_TOTAL_SUM,
                BOOKING_ONE_NUMBER_OF_PERSONS, dateBegin, dateEnd);
        Country country = new Country(COUNTRY_ID, "Country name");
        City city = new City(CITY_ID, "City name", country);
        Hotel hotel = new Hotel(HOTEL_ID, "Hotel name", city , HotelCategory.THREE_STARS);
        RoomCategory roomCategory = new RoomCategory(ROOM_CATEGORY_ID, "Room category name",
                "Room category description" );
        Room room = new Room(ROOM_ID, ROOM_ONE_NUMBER, hotel, roomCategory, ROOM_ONE_PRICE,
                ROOM_ONE_NUMBER_OF_PERSONS);
        Set<Authority> roles = new HashSet<>();
        Authority roleOne = new Authority(ROLE_ID, "username", "ROLE_ADMIN");
        roles.add(roleOne);
        User user = new User("username", "password", USER_ENABLED,
                "First name","Last name", roles);
        Booking booking = new Booking(BOOKING_ONE_ID, room, user, BOOKING_ONE_TOTAL_SUM,
                BOOKING_ONE_NUMBER_OF_PERSONS, dateBegin, dateEnd);
        given(service.saveBooking(request)).willReturn(booking);
        String requestJson = "{\"id\":\"1\",\"roomId\":\"5\",\"username\":\"username\",\"totalSum\":\"10000\"," +
                "\"persons\":\"2\",\"checkIn\":\"2018-04-01\",\"checkOut\":\"2018-04-10\"}";

        // when
        String result = mockMvc.perform(post(BOOKING_URL)
                .content(requestJson)
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andReturn().getResponse().getContentAsString();

        // then
        assertThatJson(result).when(Option.IGNORING_ARRAY_ORDER).isEqualTo(booking);
        verify(service).saveBooking(request);
        verifyNoMoreInteractions(service);
    }

    @Test
    public void getBooking() throws Exception {

        // given
        Country country = new Country(COUNTRY_ID, "Country name");
        City city = new City(CITY_ID, "City name", country);
        Hotel hotel = new Hotel(HOTEL_ID, "Hotel name", city, HotelCategory.FIVE_STARS);
        RoomCategory roomCategory = new RoomCategory(ROOM_CATEGORY_ID, "Room category name",
                "Room category description" );
        Set<Authority> roles = new HashSet<>();
        Authority roleOne = new Authority(ROLE_ID, "username", "ROLE_ADMIN");
        roles.add(roleOne);
        User user = new User("username", "password", USER_ENABLED,
                "First name","Last name", roles);
        Room roomOne = new Room(ROOM_ID, ROOM_ONE_NUMBER, hotel, roomCategory, ROOM_ONE_PRICE,
                ROOM_ONE_NUMBER_OF_PERSONS);
        Booking booking = new Booking(BOOKING_ONE_ID, roomOne, user, BOOKING_ONE_TOTAL_SUM,
                BOOKING_ONE_NUMBER_OF_PERSONS, new Date(), new Date());
        given(service.getBooking(BOOKING_ONE_ID)).willReturn(booking);

        // when
        String result = mockMvc.perform(get(BOOKING_URL.concat("/").concat("1"))
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        // then
        assertThatJson(result).when(Option.IGNORING_ARRAY_ORDER).isEqualTo(booking);
        verify(service).getBooking(BOOKING_ONE_ID);
        verifyNoMoreInteractions(service);
    }
}