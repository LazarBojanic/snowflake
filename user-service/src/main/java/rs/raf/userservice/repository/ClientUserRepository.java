package rs.raf.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rs.raf.userservice.domain.ClientUser;

@Repository
public interface ClientUserRepository extends JpaRepository<ClientUser, Long> {
    @Query("SELECT c FROM ClientUser c WHERE c.email = :email AND c.pass = :pass")
    ClientUser findClientUserByEmailAndPass(
            @Param("email") String email,
            @Param("pass") String pass
    );
    @Query("SELECT c FROM ClientUser c WHERE c.email = :email")
    ClientUser findClientUserByEmail(
            @Param("email") String email
    );

}