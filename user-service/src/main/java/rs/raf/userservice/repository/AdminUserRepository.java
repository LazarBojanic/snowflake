package rs.raf.userservice.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rs.raf.userservice.domain.AdminUser;
import rs.raf.userservice.domain.ClientUser;

import java.util.List;

@Repository
public interface AdminUserRepository extends UserRepository<AdminUser> {
    @Query("SELECT a FROM AdminUser a WHERE a.email = :email AND a.pass = :pass")
    AdminUser findAdminUserByEmailAndPass(
            @Param("email") String email,
            @Param("pass") String pass
    );
    @Query("SELECT a FROM AdminUser a WHERE a.email = :email")
    AdminUser findAdminUserByEmail(
            @Param("email") String email
    );
}
