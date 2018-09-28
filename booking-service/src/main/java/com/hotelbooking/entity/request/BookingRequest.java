package com.hotelbooking.entity.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@EqualsAndHashCode
public class BookingRequest {

    @NotNull
    private int id;

    @NotNull
    private int roomId;

    @NotEmpty
    private String username;

    @NotNull
    private int totalSum;

    @NotNull
    private int persons;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date checkIn;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date checkOut;

    @JsonCreator
    public BookingRequest(@JsonProperty(value = "id", required = true) int id,
                          @JsonProperty(value = "roomId", required = true) int roomId,
                          @JsonProperty("username") String username,
                          @JsonProperty(value = "totalSum", required = true) int totalSum,
                          @JsonProperty(value = "persons", required = true) int persons,
                          @JsonProperty("checkIn") Date checkIn,
                          @JsonProperty("checkOut") Date checkOut) {
        this.id = id;
        this.roomId = roomId;
        this.username = username;
        this.totalSum = totalSum;
        this.persons = persons;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }
}