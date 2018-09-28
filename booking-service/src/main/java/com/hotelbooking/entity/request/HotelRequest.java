package com.hotelbooking.entity.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@EqualsAndHashCode
public class HotelRequest {

    @NotNull
    private int id;

    @NotEmpty
    private String name;

    @NotNull
    private int cityId;

    @NotEmpty
    private String category;

    @JsonCreator
    public HotelRequest(@JsonProperty(value = "id", required = true) int id,
                        @JsonProperty("name") String name,
                        @JsonProperty(value = "cityId", required = true) int cityId,
                        @JsonProperty(value = "category", required = true) String category) {
        this.id = id;
        this.name = name;
        this.cityId = cityId;
        this.category = category;
    }
}
