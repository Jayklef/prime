package com.jayklef.prime.controller;

import com.jayklef.prime.entity.EmailDetails;
import com.jayklef.prime.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class EmailController {

        @Autowired
        private EmailService emailService;

        // Sending a simple Email
        @PostMapping("/sendMail")
        public String sendMail(@RequestBody EmailDetails details) {
            String status = emailService.sendSimpleMail(details);
            return status;
        }
}
