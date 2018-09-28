package com.hotelbooking.entity.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@EqualsAndHashCode
public class RoomRequest {

    @NotNull
    private int id;

    @NotNull
    private int number;

    @NotNull
    private int hotelId;

    @NotNull
    private int roomCategoryId;

    @Min(value = 1)
    private int price;

    @Min(value = 1)
    private int persons;

    @JsonCreator
    public RoomRequest(@JsonProperty(value = "id", required = true) int id,
                       @JsonProperty(value = "number", required = true) int number,
                       @JsonProperty(value = "hotelId", required = true) int hotelId,
                       @JsonProperty(value = "roomCategoryId", required = true) int roomCategoryId,
                       @JsonProperty(value = "price", required = true) int price,
                       @JsonProperty(value = "persons", required = true) int persons){
        this.id = id;
        this.number = number;
        this.hotelId = hotelId;
        this.roomCategoryId = roomCategoryId;
        this.price = price;
        this.persons = persons;
    }
}
