package com.hotelbooking.entity.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@EqualsAndHashCode
public class CityRequest {

    @NotNull
    private int id;

    @NotEmpty
    private String name;

    @NotNull
    private int countryId;

    @JsonCreator
    public CityRequest(@JsonProperty(value = "id", required = true) int id,
                       @JsonProperty("name") String name,
                       @JsonProperty(value = "countryId", required = true) int countryId) {
        this.id = id;
        this.name = name;
        this.countryId = countryId;
    }
}
