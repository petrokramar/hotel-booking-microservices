package com.hotelbooking.entity.dto;

import com.hotelbooking.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class RoomListDTO {
    private List<Room> rooms;
    private long totalElements;
}
