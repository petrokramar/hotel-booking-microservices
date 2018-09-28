package com.hotelbooking.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class ApiError {
    //TODO Change LocalDateTime to String or delete
    private LocalDateTime date;
    private int status;
    private String error;
    private String message;
    private String path;
    private String method;
}
