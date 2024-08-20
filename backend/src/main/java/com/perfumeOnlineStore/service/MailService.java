package com.perfumeOnlineStore.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {
    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String username;

    public void sendMail(String address, String title, String content) throws MessagingException {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(username);
//        message.setTo(address);
//        message.setSubject(title);
//        message.setText(content);
//
//        mailSender.send(message);

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

        mimeMessageHelper.setFrom(username);
        mimeMessageHelper.setTo(address);
        mimeMessageHelper.setSubject(title);
        mimeMessageHelper.setText(content, true);

        mailSender.send(mimeMessage);

    }
}
