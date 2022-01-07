package com.poc.email.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailSMTPConfig {

    @Value("${smtp.relay.host}")
    private String emailHost;
    @Bean
    public MailSender emailSmtpConfig() {
       JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
       javaMailSender.setHost(emailHost);
       javaMailSender.setDefaultEncoding("UTF-8");
       return javaMailSender;
    }

    @Bean
    public SimpleMailMessage simpleMailMessage() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("noreply@noone.com");
        return  simpleMailMessage;
    }
}
