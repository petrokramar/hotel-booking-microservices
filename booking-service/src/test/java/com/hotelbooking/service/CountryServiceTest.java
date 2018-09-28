package com.hotelbooking.service;

import com.hotelbooking.entity.Country;
import com.hotelbooking.entity.request.CountryRequest;
import com.hotelbooking.exceptions.DataNotFoundException;
import com.hotelbooking.repository.CountryRepository;
import com.hotelbooking.service.impl.CountryServiceImpl;
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

public class CountryServiceTest {

    private final int COUNTRY_ONE_ID = 1;
    private final int COUNTRY_TWO_ID = 2;
    private final int COUNTRY_THREE_ID = 3;
    private CountryRepository repository;
    private CountryService service;

    @Before
    public void setUp() {
        repository = mock(CountryRepository.class);
        service = new CountryServiceImpl(repository);
    }

    @Test
    public void getAllCountries() {

        // given
        List<Country> expectedCountries = new ArrayList<>();
        Country countryOne = new Country(COUNTRY_ONE_ID, "Country one name");
        expectedCountries.add(countryOne);
        Country countryTwo = new Country(COUNTRY_TWO_ID, "Country two name");
        expectedCountries.add(countryTwo);
        Country countryThree = new Country(COUNTRY_THREE_ID, "Country three name");
        expectedCountries.add(countryThree);
        given(repository.findAllByOrderByName()).willReturn(expectedCountries);

        //when
        List<Country> actualCountries = service.getAllCountries();

        //then
        assertEquals(expectedCountries, actualCountries);
        verify(repository).findAllByOrderByName();
        verifyNoMoreInteractions(repository);
    }

    @Test
    public void getCountry() {

        // given
        Country expectedCountry = new Country(COUNTRY_ONE_ID, "Country name");
        given(repository.findOne(COUNTRY_ONE_ID)).willReturn(expectedCountry);

        //when
        Country actualCountry = service.getCountry(COUNTRY_ONE_ID);

        //then
        assertEquals(expectedCountry, actualCountry);
        verify(repository).findOne(COUNTRY_ONE_ID);
        verifyNoMoreInteractions(repository);
    }

    @Test(expected = DataNotFoundException.class)
    public void getCountryNotFound() {

        // given
        given(repository.findOne(COUNTRY_ONE_ID)).willReturn(null);

        //when
        Country country = service.getCountry(COUNTRY_ONE_ID);

        fail();
    }

    @Test
    public void saveCountry() {

        // given
        CountryRequest request = new CountryRequest(COUNTRY_ONE_ID, "Country name");
        Country expectedCountry = new Country(request.getId(), request.getName());
        given(repository.save(expectedCountry)).willReturn(expectedCountry);

        //when
        Country actualCountry = service.saveCountry(request);

        //then
        assertEquals(expectedCountry, actualCountry);
        verify(repository).save(expectedCountry);
        verifyNoMoreInteractions(repository);
    }
}