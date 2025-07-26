package com.emranhss.project.service;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;


    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

<<<<<<< HEAD
    public void sendSimpleEmail(String to, String subject,String body ) throws MessagingException{
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(body, true);
=======
    public  void sendSimpleEmail(String to, String subject, String body) throws MessagingException {

        MimeMessage message=javaMailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(message, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(body,   true);
>>>>>>> 7fb61327aaf490c488ec26c2bf20092d91e63e22

        javaMailSender.send(message);

    }

<<<<<<< HEAD
=======

>>>>>>> 7fb61327aaf490c488ec26c2bf20092d91e63e22

}
