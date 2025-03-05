package com.backend.tourBooking.controller;


import com.backend.tourBooking.dto.MailDTO;
import com.backend.tourBooking.service.IMailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MailController {

    @Autowired
    public IMailService iMailService;

    @PostMapping("/sendMessage")
    private ResponseEntity<String> sendMail (@RequestBody MailDTO mail ) throws MessagingException {

        iMailService.sendMail(mail);
        return new ResponseEntity<>("Mail " + "enviado correctamente ", HttpStatus.OK);


    }


}
