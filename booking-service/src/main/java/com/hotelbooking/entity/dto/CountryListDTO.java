package com.hotelbooking.entity.dto;

import com.hotelbooking.entity.Country;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class CountryListDTO {
    private List<Country> countries;
    private long totalElements;
}
