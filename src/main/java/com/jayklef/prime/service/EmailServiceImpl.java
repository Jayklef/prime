package com.jayklef.prime.service;

import com.jayklef.prime.entity.EmailDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public String sendSimpleMail(EmailDetails details) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(details.getSender());
        message.setFrom(details.getRecipient());
        message.setSubject(details.getSubject());
        message.setText(details.getMessage());

        javaMailSender.send(message);
        return "Confirmation mail sent successfully";
    }





}
