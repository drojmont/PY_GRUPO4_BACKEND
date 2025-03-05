package com.backend.tourBooking.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@PropertySource(value = "classpath:email.properties", ignoreResourceNotFound = false)

public class MailConfig {

    @Value("${email.username}")
    private String mail;

    @Value("${email.password}")
    private String password;


    @Bean
    public Properties getMailProperties(){
        Properties properties= new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        return properties;

    }

    @Bean
    public JavaMailSender javaMailSender(){

        JavaMailSenderImpl mailSender= new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com"); //
        mailSender.setPort(587); //
        mailSender.setUsername(mail);
        mailSender.setPassword(password);
        mailSender.setJavaMailProperties(getMailProperties());


        return mailSender;

    }

    @Bean
    public ResourceLoader resourceLoader(){
        return new DefaultResourceLoader();
    }


}
