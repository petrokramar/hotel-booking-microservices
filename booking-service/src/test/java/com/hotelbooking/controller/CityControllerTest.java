package com.hotelbooking.controller;

import com.hotelbooking.config.SecurityConfig;
import com.hotelbooking.entity.City;
import com.hotelbooking.entity.Country;
import com.hotelbooking.entity.request.CityRequest;
import com.hotelbooking.service.CityService;
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
@WebMvcTest(CityController.class)
@Import(SecurityConfig.class)
public class CityControllerTest{

    private final String CITIES_URL = "/api/cities";
    private final int CITY_ONE_ID = 1;
    private final int CITY_TWO_ID = 2;
    private final int CITY_THREE_ID = 3;
    private final int COUNTRY_ID = 4;

    @MockBean
    private CityService service;

    @Inject
    private MockMvc mockMvc;

    @Test
    public void getAllCities() throws Exception {

        // given
        Country country = new Country(COUNTRY_ID, "Country name");
        List<City> cities = new ArrayList<>();
        cities.add(new City(CITY_ONE_ID, "City one name", country));
        cities.add(new City(CITY_TWO_ID, "City two name", country));
        cities.add(new City(CITY_THREE_ID, "City three name", country));
        given(service.getAllCities()).willReturn(cities);

        // when
        String result = mockMvc.perform(get(CITIES_URL)
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        // then
        assertThatJson(result).when(Option.IGNORING_ARRAY_ORDER).isEqualTo(cities);
        verify(service).getAllCities();
        verifyNoMoreInteractions(service);
    }

    @Test
    public void saveCity() throws Exception {

        // given
        Country country = new Country(COUNTRY_ID, "Country name");
        City city = new City(CITY_ONE_ID, "City name", country);
        CityRequest request = new CityRequest(CITY_ONE_ID, "City name", COUNTRY_ID);
        given(service.saveCity(request)).willReturn(city);
        String requestJson = "{\"id\":\"1\",\"name\":\"City name\",\"countryId\":\"4\"}";

        // when
        String result = mockMvc.perform(post(CITIES_URL)
                .content(requestJson)
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andReturn().getResponse().getContentAsString();

        // then
        assertThatJson(result).when(Option.IGNORING_ARRAY_ORDER).isEqualTo(city);
        verify(service).saveCity(request);
        verifyNoMoreInteractions(service);
    }

    @Test
    public void getCity() throws Exception {

        // given
        Country country = new Country(COUNTRY_ID, "Country name");
        City city = new City(CITY_ONE_ID, "City name", country);
        given(service.getCity(CITY_ONE_ID)).willReturn(city);

        // when
        String result = mockMvc.perform(get(CITIES_URL.concat("/").concat("1"))
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        // then
        assertThatJson(result).when(Option.IGNORING_ARRAY_ORDER).isEqualTo(city);
        verify(service).getCity(CITY_ONE_ID);
        verifyNoMoreInteractions(service);
    }
}