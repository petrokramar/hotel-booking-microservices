package com.hotelbooking.entity.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@EqualsAndHashCode
public class CountryRequest {

    @NotNull
    private int id;

    @NotEmpty
    private String name;

    @JsonCreator
    public CountryRequest(@JsonProperty(value = "id", required = true) int id,
                          @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }
}
