package rs.raf.notificationservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.raf.notificationservice.domain.NotificationType;

@Repository
public interface NotificationTypeRepository extends JpaRepository<NotificationType, Integer> {

}