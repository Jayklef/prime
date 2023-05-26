package com.jayklef.prime.entity;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;
@Data
public class ErrorResponse {

    private Integer statusCode;
    private HttpStatus status;
    private String message;
    private Date timestamp;

}
