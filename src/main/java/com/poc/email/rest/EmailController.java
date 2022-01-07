package com.poc.email.rest;

import com.poc.email.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private SendEmailService sendEmailService;

    @PostMapping("/api/sendemail")
    public String sendEmail(@RequestBody String content) {
        System.out.println("content = " + content);
        sendEmailService.sendEmail(content);
        return "Success";
    }
}
