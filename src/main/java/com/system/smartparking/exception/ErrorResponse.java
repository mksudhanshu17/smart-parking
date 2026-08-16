package com.system.smartparking.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ErrorResponse {
    private String message;

    public  ErrorResponse(String message){
        this.message = message;
    }
}
