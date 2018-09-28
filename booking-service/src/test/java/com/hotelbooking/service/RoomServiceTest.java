package com.hotelbooking.service;

import com.hotelbooking.entity.*;
import com.hotelbooking.entity.request.RoomRequest;
import com.hotelbooking.exceptions.DataNotFoundException;
import com.hotelbooking.repository.HotelRepository;
import com.hotelbooking.repository.RoomCategoryRepository;
import com.hotelbooking.repository.RoomRepository;
import com.hotelbooking.service.impl.RoomServiceImpl;
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

public class RoomServiceTest {

    private final int ROOM_ONE_ID = 1;
    private final int ROOM_TWO_ID = 2;
    private final int ROOM_THREE_ID = 3;
    private final int COUNTRY_ID = 4;
    private final int CITY_ID = 5;
    private final int HOTEL_ID = 6;
    private final int ROOM_CATEGORY_ID = 7;
    private final int ROOM_ONE_NUMBER = 1;
    private final int ROOM_TWO_NUMBER = 2;
    private final int ROOM_THREE_NUMBER = 3;
    private final int ROOM_ONE_PRICE = 10000;
    private final int ROOM_TWO_PRICE = 20000;
    private final int ROOM_THREE_PRICE = 30000;
    private final int ROOM_ONE_NUMBER_OF_PERSONS = 2;
    private final int ROOM_TWO_NUMBER_OF_PERSONS = 3;
    private final int ROOM_THREE_NUMBER_OF_PERSONS = 4;

    private HotelRepository hotelRepository;
    private RoomCategoryRepository roomCategoryRepository;
    private RoomRepository repository;
    private RoomService service;

    @Before
    public void setUp() {
        repository = mock(RoomRepository.class);
        hotelRepository = mock(HotelRepository.class);
        roomCategoryRepository = mock(RoomCategoryRepository.class);
        service = new RoomServiceImpl(repository, hotelRepository, roomCategoryRepository);
    }

    @Test
    public void getAllRooms() {

        // given
        Country country = new Country(COUNTRY_ID, "Country name");
        City city = new City(CITY_ID, "City name", country);
        Hotel hotel = new Hotel(HOTEL_ID, "Hotel name 1" , city , HotelCategory.THREE_STARS);
        RoomCategory roomCategory = new RoomCategory(ROOM_CATEGORY_ID, "Room category name",
                "Room category description" );

        List<Room> expectedRooms = new ArrayList<>();
        Room roomOne = new Room(ROOM_ONE_ID, ROOM_ONE_NUMBER, hotel, roomCategory, ROOM_ONE_PRICE,
                ROOM_ONE_NUMBER_OF_PERSONS);
        expectedRooms.add(roomOne);
        Room roomTwo = new Room(ROOM_TWO_ID, ROOM_TWO_NUMBER, hotel, roomCategory, ROOM_TWO_PRICE,
                ROOM_TWO_NUMBER_OF_PERSONS);
        expectedRooms.add(roomTwo);
        Room roomThree = new Room(ROOM_THREE_ID, ROOM_THREE_NUMBER, hotel, roomCategory, ROOM_THREE_PRICE,
                ROOM_THREE_NUMBER_OF_PERSONS);
        expectedRooms.add(roomThree);
        given(repository.findAll()).willReturn(expectedRooms);

        //when
        List<Room> actualRooms = service.getAllRooms();

        //then
        assertEquals(expectedRooms, actualRooms);
        verify(repository).findAll();
        verifyNoMoreInteractions(repository);
    }

    @Test
    public void getRoom() {

        // given
        Country country = new Country(COUNTRY_ID, "Country name");
        City city = new City(CITY_ID, "City name", country);
        Hotel hotel = new Hotel(HOTEL_ID, "Hotel name" , city , HotelCategory.THREE_STARS);
        RoomCategory roomCategory = new RoomCategory(ROOM_CATEGORY_ID, "Room category name",
                "Room category description" );
        Room expectedRoom = new Room(ROOM_ONE_ID, ROOM_ONE_NUMBER, hotel, roomCategory, ROOM_ONE_PRICE,
                ROOM_ONE_NUMBER_OF_PERSONS);
        given(repository.findOne(ROOM_ONE_ID)).willReturn(expectedRoom);

        //when
        Room actualRoom = service.getRoom(ROOM_ONE_ID);

        //then
        assertEquals(expectedRoom, actualRoom);
        verify(repository).findOne(ROOM_ONE_ID);
        verifyNoMoreInteractions(repository);
    }

    @Test(expected = DataNotFoundException.class)
    public void getRoomNotFound() {

        // given
        given(repository.findOne(ROOM_ONE_ID)).willReturn(null);

        //when
        Room room = service.getRoom(ROOM_ONE_ID);

        fail();
    }

    @Test
    public void saveRoom() {

        // given
        RoomRequest request = new RoomRequest(ROOM_ONE_ID, ROOM_ONE_NUMBER, HOTEL_ID, ROOM_CATEGORY_ID, ROOM_ONE_PRICE,
                ROOM_ONE_NUMBER_OF_PERSONS);
        Country country = new Country(COUNTRY_ID, "Country name");
        City city = new City(CITY_ID, "City name", country);
        Hotel hotel = new Hotel(HOTEL_ID, "Hotel name", city , HotelCategory.THREE_STARS);
        RoomCategory roomCategory = new RoomCategory(ROOM_CATEGORY_ID, "Room category name",
                "Room category description" );
        Room expectedRoom = new Room(ROOM_ONE_ID, ROOM_ONE_NUMBER, hotel, roomCategory, ROOM_ONE_PRICE,
                ROOM_ONE_NUMBER_OF_PERSONS);
        given(hotelRepository.findOne(HOTEL_ID)).willReturn(hotel);
        given(roomCategoryRepository.findOne(ROOM_CATEGORY_ID)).willReturn(roomCategory);
        given(repository.save(expectedRoom)).willReturn(expectedRoom);

        //when
        Room actualRoom = service.saveRoom(request);

        //then
        assertEquals(expectedRoom, actualRoom);
        verify(hotelRepository).findOne(HOTEL_ID);
        verifyNoMoreInteractions(hotelRepository);
        verify(roomCategoryRepository).findOne(ROOM_CATEGORY_ID);
        verifyNoMoreInteractions(roomCategoryRepository);
        verify(repository).save(expectedRoom);
        verifyNoMoreInteractions(repository);
    }
}