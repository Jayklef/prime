package com.jayklef.prime.service;


import com.jayklef.prime.entity.EmailDetails;

public interface EmailService {

        String sendSimpleMail(EmailDetails details);
}
