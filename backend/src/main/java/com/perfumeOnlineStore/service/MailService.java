package com.perfumeOnlineStore.service;

import com.perfumeOnlineStore.entity.Mail;
import com.perfumeOnlineStore.repository.MailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {
    private final JavaMailSender mailSender;
    private final MailRepository mailRepository;

    @Value("${spring.mail.username}")
    private String from;

    public void sendMail(String to,
                         String title,
                         String context,
                         String action,
                         String controller
    ) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(title);
        message.setText(context);

        mailSender.send(message);

        saveMail(message, action, controller);
    }

    private void saveMail(SimpleMailMessage message,
                          String action,
                          String controller
    ) {
        Mail mail = Mail.builder()
                .action(action)
                .controller(controller)
                .subject(message.getSubject())
                .recipient(message.getTo().toString())
                .isSentSuccessfully(true).
                build();

        mailRepository.save(mail);
    }
}
