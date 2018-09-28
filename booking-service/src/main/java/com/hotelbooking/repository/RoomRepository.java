package com.hotelbooking.repository;

import com.hotelbooking.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface RoomRepository extends CrudRepository<Room, Integer> {

    @Query("Select r from Room r where r.hotel.id = ?1 order by r.number")
    Page<Room> findHotelRoomsPage(int hotelId, Pageable pageable);

    @Query("Select r from Room r where r.hotel.id = :hotelId and r.id not in (Select b.room.id from Booking b " +
            "where (b.room.hotel.id = :hotelId and b.checkIn < :checkOut and b.checkOut > :checkIn))")
    Page<Room> findHotelFreeRoomsPage(@Param(value = "hotelId") int hotelId,
                                      @Param(value = "checkIn") Date checkIn,
                                      @Param(value = "checkOut") Date checkOut,
                                      Pageable pageable);

    @Query("Select (case when count(b) = 0 then true else false end) from Booking b " +
            "where (b.room.id = :id and b.checkIn < :checkOut and b.checkOut > :checkIn)")
    boolean checkRoomIsFree(@Param(value = "id") int id,
                            @Param(value = "checkIn") Date checkIn,
                            @Param(value = "checkOut") Date checkOut);
}
