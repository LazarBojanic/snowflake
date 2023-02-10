package rs.raf.userservice.repository;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rs.raf.userservice.domain.ClientUser;
import rs.raf.userservice.domain.ManagerUser;

@Repository
public interface ManagerUserRepository extends UserRepository<ManagerUser> {

    @Query("SELECT m FROM ManagerUser m WHERE m.email = :email AND m.pass = :pass")
    ManagerUser findManagerUserByEmailAndPass(
            @Param("email") String email,
            @Param("pass") String pass
    );
    @Query("SELECT m FROM ManagerUser m WHERE m.email = :email")
    ManagerUser findManagerUserByEmail(
            @Param("email") String email
    );
}