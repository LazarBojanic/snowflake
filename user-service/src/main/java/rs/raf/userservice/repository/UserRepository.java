package rs.raf.userservice.repository;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import rs.raf.userservice.domain.ServiceUser;

import java.util.List;

@Repository
public interface UserRepository<T extends ServiceUser> extends JpaRepository<T, Long> {
}
