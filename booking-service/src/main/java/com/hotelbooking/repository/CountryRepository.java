package com.hotelbooking.repository;

import com.hotelbooking.entity.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.criteria.From;
import java.util.List;

public interface CountryRepository  extends CrudRepository<Country, Integer> {

    List<Country> findAllByOrderByName();

    @Query("Select c from Country c where lower(c.name) like lower(concat('%', :filter,'%'))")
    Page<Country> findCountryPage(@Param(value = "filter") String filter, Pageable pageable);
}
