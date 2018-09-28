package com.hotelbooking.repository;

import com.hotelbooking.entity.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CityRepository extends CrudRepository<City, Integer> {

    List<City> findAllByOrderByName();

    @Query("Select c from City c where lower(c.name) like lower(concat('%', :filter,'%'))")
    Page<City> findCityPage(@Param(value = "filter") String filter, Pageable pageable);
}
