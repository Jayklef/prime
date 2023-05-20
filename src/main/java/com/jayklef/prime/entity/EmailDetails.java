package com.jayklef.prime.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetails {

    private String Sender;
    private String recipient;
    private String message;
    private String subject;
}
