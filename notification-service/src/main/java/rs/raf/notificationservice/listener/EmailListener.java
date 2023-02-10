package rs.raf.notificationservice.listener;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import rs.raf.core.dto.notificationservice.base.*;
import rs.raf.notificationservice.listener.helper.MessageHelper;
import rs.raf.notificationservice.mapper.NotificationMapper;
import rs.raf.notificationservice.repository.NotificationRepository;
import rs.raf.notificationservice.service.EmailService;

import javax.jms.JMSException;
import javax.jms.Message;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmailListener {
    @Autowired
    private MessageHelper messageHelper;
    @Autowired
    private EmailService emailService;
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private NotificationMapper notificationMapper;

    @JmsListener(destination = "${destination.registrationConfirmationNotification}", concurrency = "5-10")
    public void registrationConfirmationNotification(Message message) throws JMSException {
        RegistrationConfirmationNotificationDto registrationConfirmationNotificationDto = messageHelper.getMessage(message, RegistrationConfirmationNotificationDto.class);
        NotificationDto notificationDto = notificationMapper.registrationConfirmationNotificationDtoToNotificationDto(registrationConfirmationNotificationDto);
        if(emailService.sendSimpleMessage(notificationDto)){
            notificationRepository.save(notificationMapper.notificationDtoToNotification(notificationDto));
        }
    }

    @JmsListener(destination = "${destination.changePasswordNotification}", concurrency = "5-10")
    public void changePasswordNotification(Message message) throws JMSException {
        ChangePasswordNotificationDto changePasswordNotificationDto = messageHelper.getMessage(message, ChangePasswordNotificationDto.class);
        NotificationDto notificationDto = notificationMapper.changePasswordNotificationDtoToNotificationDto(changePasswordNotificationDto);
        if(emailService.sendSimpleMessage(notificationDto)){
            notificationRepository.save(notificationMapper.notificationDtoToNotification(notificationDto));
        }
    }

    @JmsListener(destination = "${destination.reservationMadeNotification}", concurrency = "5-10")
    public void reservationMadeNotification(Message message) throws JMSException {
        ReservationMadeNotificationDto reservationMadeNotificationDto = messageHelper.getMessage(message, ReservationMadeNotificationDto.class);
        NotificationDto notificationDto = notificationMapper.reservationMadeNotificationDtoToNotificationDto(reservationMadeNotificationDto);
        if(emailService.sendSimpleMessage(notificationDto)){
            notificationRepository.save(notificationMapper.notificationDtoToNotification(notificationDto));
        }
    }
    @JmsListener(destination = "${destination.reservationCanceledNotification}", concurrency = "5-10")
    public void reservationCanceledNotification(Message message) throws JMSException {
        ReservationCanceledNotificationDto reservationCanceledNotificationDto = messageHelper.getMessage(message, ReservationCanceledNotificationDto.class);
        NotificationDto notificationDto = notificationMapper.reservationCanceledNotificationDtoToNotificationDto(reservationCanceledNotificationDto);
        if(emailService.sendSimpleMessage(notificationDto)){
            notificationRepository.save(notificationMapper.notificationDtoToNotification(notificationDto));
        }
    }
    @JmsListener(destination = "${destination.reservationReminderNotification}", concurrency = "5-10")
    public void reservationReminderNotification(Message message) throws JMSException {
        ReservationReminderNotificationDto reservationReminderNotificationDto = messageHelper.getMessage(message, ReservationReminderNotificationDto.class);
        NotificationDto notificationDto = notificationMapper.reservationReminderNotificationDtoToNotificationDto(reservationReminderNotificationDto);
        if(emailService.sendSimpleMessage(notificationDto)){
            notificationRepository.save(notificationMapper.notificationDtoToNotification(notificationDto));
        }
    }
}
