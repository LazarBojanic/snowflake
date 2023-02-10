package rs.raf.notificationservice.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rs.raf.core.dto.notificationservice.base.*;
import rs.raf.notificationservice.domain.Notification;
import rs.raf.notificationservice.domain.NotificationType;
import rs.raf.notificationservice.repository.NotificationTypeRepository;

import java.util.Optional;

@Component
public class NotificationMapper {
    @Autowired
    NotificationTypeRepository notificationTypeRepository;
    public Notification notificationDtoToNotification(NotificationDto notificationDto){
        Optional<NotificationType> optionalNotificationType = notificationTypeRepository.findById(notificationDto.getNotification_type_id());
        if(optionalNotificationType.isPresent()){
            NotificationType notificationType = optionalNotificationType.get();
            return Notification.builder()
                    .id(notificationDto.getId())
                    .notification_type(notificationType)
                    .from(notificationDto.getFrom())
                    .to(notificationDto.getTo())
                    .subject(notificationDto.getSubject())
                    .text(notificationDto.getText())
                    .date_sent(notificationDto.getDate_sent())
                    .build();
        }
        return null;
    }
    public NotificationDto notificationToNotificationDto(Notification notification){
        return NotificationDto.builder()
                .id(notification.getId())
                .notification_type_id(notification.getNotification_type().getId())
                .from(notification.getFrom())
                .to(notification.getTo())
                .subject(notification.getSubject())
                .text(notification.getText())
                .date_sent(notification.getDate_sent())
                .build();
    }



    public NotificationDto registrationConfirmationNotificationDtoToNotificationDto(RegistrationConfirmationNotificationDto registrationConfirmationNotificationDto){
        return NotificationDto.builder()
                .id(registrationConfirmationNotificationDto.getId())
                .notification_type_id(registrationConfirmationNotificationDto.getNotification_type_id())
                .from(registrationConfirmationNotificationDto.getFrom())
                .to(registrationConfirmationNotificationDto.getTo())
                .subject(registrationConfirmationNotificationDto.getSubject())
                .text(registrationConfirmationNotificationDto.getText())
                .date_sent(registrationConfirmationNotificationDto.getDate_sent())
                .build();
    }


    public NotificationDto changePasswordNotificationDtoToNotificationDto(ChangePasswordNotificationDto changePasswordNotificationDto){
        return NotificationDto.builder()
                .id(changePasswordNotificationDto.getId())
                .notification_type_id(changePasswordNotificationDto.getNotification_type_id())
                .from(changePasswordNotificationDto.getFrom())
                .to(changePasswordNotificationDto.getTo())
                .subject(changePasswordNotificationDto.getSubject())
                .text(changePasswordNotificationDto.getText())
                .date_sent(changePasswordNotificationDto.getDate_sent())
                .build();
    }


    public NotificationDto reservationMadeNotificationDtoToNotificationDto(ReservationMadeNotificationDto reservationMadeNotificationDto){
        return NotificationDto.builder()
                .id(reservationMadeNotificationDto.getId())
                .notification_type_id(reservationMadeNotificationDto.getNotification_type_id())
                .from(reservationMadeNotificationDto.getFrom())
                .to(reservationMadeNotificationDto.getTo())
                .subject(reservationMadeNotificationDto.getSubject())
                .text(reservationMadeNotificationDto.getText())
                .date_sent(reservationMadeNotificationDto.getDate_sent())
                .build();
    }


    public NotificationDto reservationCanceledNotificationDtoToNotificationDto(ReservationCanceledNotificationDto reservationCanceledNotificationDto){
        return NotificationDto.builder()
                .id(reservationCanceledNotificationDto.getId())
                .notification_type_id(reservationCanceledNotificationDto.getNotification_type_id())
                .from(reservationCanceledNotificationDto.getFrom())
                .to(reservationCanceledNotificationDto.getTo())
                .subject(reservationCanceledNotificationDto.getSubject())
                .text(reservationCanceledNotificationDto.getText())
                .date_sent(reservationCanceledNotificationDto.getDate_sent())
                .build();
    }


    public NotificationDto reservationReminderNotificationDtoToNotificationDto(ReservationReminderNotificationDto reservationReminderNotificationDto){
        return NotificationDto.builder()
                .id(reservationReminderNotificationDto.getId())
                .notification_type_id(reservationReminderNotificationDto.getNotification_type_id())
                .from(reservationReminderNotificationDto.getFrom())
                .to(reservationReminderNotificationDto.getTo())
                .subject(reservationReminderNotificationDto.getSubject())
                .text(reservationReminderNotificationDto.getText())
                .date_sent(reservationReminderNotificationDto.getDate_sent())
                .build();
    }


}
