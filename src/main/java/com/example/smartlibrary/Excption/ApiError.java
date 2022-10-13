package com.example.smartlibrary.Excption;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


import java.time.LocalDateTime;
import java.util.List;

@Data
public class ApiError {
    private int status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String debugMessage;
    private List<ApiSubError> subErrors;

    public ApiError(int status, String message, Throwable exception){
        this.status = status;
        this.message = message;
        this.debugMessage = exception.getLocalizedMessage();
        this.timestamp = LocalDateTime.now();
    }
}
