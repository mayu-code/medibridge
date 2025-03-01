package com.main.medibridge.Dto;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataReponse {
    private String message;
    private HttpStatus status;
    private int statusCode;
    private Object data;
    
}
