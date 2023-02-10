package rs.raf.notificationservice.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import rs.raf.core.dto.notificationservice.base.NotificationDto;

@Component
public class EmailService {

    @Autowired
    public JavaMailSender mailSender;

    public boolean sendSimpleMessage(NotificationDto notificationDto) {
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(notificationDto.getFrom());
            message.setTo(notificationDto.getTo());
            message.setSubject(notificationDto.getSubject());
            message.setText(notificationDto.getText());
            message.setSentDate(notificationDto.getDate_sent());
            mailSender.send(message);
            return true;
        }
        catch(MailException e){
            return false;
        }
    }
}
