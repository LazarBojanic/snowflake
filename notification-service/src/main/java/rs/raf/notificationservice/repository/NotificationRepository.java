package rs.raf.notificationservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.raf.notificationservice.domain.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

}