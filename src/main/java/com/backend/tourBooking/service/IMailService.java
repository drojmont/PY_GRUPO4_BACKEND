package com.backend.tourBooking.service;

import com.backend.tourBooking.dto.MailDTO;
import jakarta.mail.MessagingException;

public interface IMailService {
    public void sendMail(MailDTO mail) throws MessagingException;
}
