package com.hotelbooking.entity.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@EqualsAndHashCode
public class RoomCategoryRequest {

    @NotNull
    private int id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    @JsonCreator
    public RoomCategoryRequest(@JsonProperty(value = "id", required = true) int id,
                               @JsonProperty("name") String name,
                               @JsonProperty("description") String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
