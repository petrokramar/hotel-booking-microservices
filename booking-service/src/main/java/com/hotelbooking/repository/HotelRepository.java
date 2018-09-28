package com.hotelbooking.repository;

import com.hotelbooking.entity.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface HotelRepository extends CrudRepository<Hotel, Integer> {

    @Query("Select h from Hotel h where lower(h.name) like lower(concat('%', :filter,'%'))")
    Page<Hotel> findHotelPage(@Param(value = "filter") String filter, Pageable pageable);

    @Query("Select h from Hotel h where h.id in (select distinct r.hotel.id from Room r " +
            "where (r.hotel.city.id = :cityId and r.id not in (select b.room.id from Booking b " +
            "where (b.room.hotel.city.id = :cityId and b.checkIn < :checkOut and b.checkOut > :checkIn )))) " +
            "order by h.name")
    Page<Hotel> findHotelsWithFreeRoomsPage(@Param(value = "cityId") int cityId,
                                      @Param(value = "checkIn") Date checkIn,
                                      @Param(value = "checkOut") Date checkOut,
                                      Pageable pageable);
}