package com.poc.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService {

    @Autowired
    private MailSender mailSender;
    @Autowired
    private SimpleMailMessage simpleMailMessage;

    @Value("${send.email.to}")
    private String sendEmailTo;

    public String sendEmail(String content){
        simpleMailMessage.setTo(sendEmailTo);
        simpleMailMessage.setText(content);
        mailSender.send(simpleMailMessage);
        return "SUCCESS";
    }
}
