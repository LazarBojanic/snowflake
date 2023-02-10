package rs.raf.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rs.raf.userservice.domain.AdminUser;
import rs.raf.userservice.domain.ClientUser;
import rs.raf.userservice.domain.UserStatus;

@Repository
public interface UserStatusRepository extends JpaRepository<UserStatus, Long> {
    @Query("SELECT userStatus FROM UserStatus userStatus WHERE userStatus.client_user.id = :clientUserId")
    UserStatus findUserStatusByClientUserId(
            @Param("clientUserId") Long clientUserId
    );
}
