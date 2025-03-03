package com.backend.tourBooking.service.impl;

import com.backend.tourBooking.dto.MailDTO;
import com.backend.tourBooking.service.IMailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service

public class MailServiceImpl implements IMailService {

    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;

    public MailServiceImpl(JavaMailSender javaMailSender, TemplateEngine templateEngine) {
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
    }

    public void sendMail(MailDTO mail) throws MessagingException {

       try { MimeMessage message =
               javaMailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(mail.getToUser());
            helper.setSubject(mail.getSubject());

            Context context = new Context();
            context.setVariable("message", mail.getMessage());
            String contentHTML = templateEngine.process("mail", context);
            helper.setText(contentHTML, true);

            javaMailSender.send(message);
        } catch (Exception e){
           throw new RuntimeException("Error" + "al enviar el Mail: " + e.getMessage(), e );
       }

    }




}
