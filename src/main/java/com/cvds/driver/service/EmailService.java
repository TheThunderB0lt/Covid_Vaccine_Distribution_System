package com.cvds.driver.service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    JavaMailSender javaMailSender;

    public void generateMail(String to, String sub, String text) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");

        try {
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(sub);
            mimeMessageHelper.setText(text);
            javaMailSender.send(mimeMessage);
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
