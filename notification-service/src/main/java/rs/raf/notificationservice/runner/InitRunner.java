package rs.raf.notificationservice.runner;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import rs.raf.notificationservice.domain.NotificationType;
import rs.raf.notificationservice.repository.NotificationTypeRepository;

import java.text.SimpleDateFormat;

@Profile({"default"})
@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InitRunner implements CommandLineRunner {

    @Autowired
    NotificationTypeRepository notificationTypeRepository;
    @Override
    public void run(String... args) throws Exception {
        /*NotificationType registrationConfirmationNotification = new NotificationType(0, "registrationConfirmationNotification");
        NotificationType changePasswordNotification = new NotificationType(1, "changePasswordNotification");
        NotificationType registrationMadeNotification = new NotificationType(2, "registrationMadeNotification");
        NotificationType registrationCanceledNotification = new NotificationType(3, "registrationCanceledNotification");
        NotificationType registrationReminderNotification = new NotificationType(4, "registrationReminderNotification");

        notificationTypeRepository.save(registrationConfirmationNotification);
        notificationTypeRepository.save(changePasswordNotification);
        notificationTypeRepository.save(registrationMadeNotification);
        notificationTypeRepository.save(registrationCanceledNotification);
        notificationTypeRepository.save(registrationReminderNotification);*/
    }
}