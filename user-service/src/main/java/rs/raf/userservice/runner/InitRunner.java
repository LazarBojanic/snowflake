package rs.raf.userservice.runner;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import rs.raf.userservice.domain.AdminUser;
import rs.raf.userservice.domain.Rank;
import rs.raf.userservice.domain.UserRole;
import rs.raf.userservice.repository.*;
import rs.raf.userservice.security.Hasher;

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
    private UserRoleRepository userRoleRepository;
    @Autowired
    private UserRepository<AdminUser> userRepository;
    @Autowired
    private AdminUserRepository adminUserRepository;
    @Autowired
    private ClientUserRepository clientUserRepository;
    @Autowired
    private ManagerUserRepository managerUserRepository;
    @Autowired
    private UserStatusRepository userStatusRepository;
    @Autowired
    private RankRepository rankRepository;
    @Override
    public void run(String... args) throws Exception {
        /*adminUserRepository.deleteAll();
        userRoleRepository.deleteAll();
        rankRepository.deleteAll();

        Rank bronzeRank = new Rank(0, "bronze", 0, 15);
        Rank silverRank = new Rank(1, "silver", 15, 30);
        Rank goldRank = new Rank(2, "gold", 30, 45);
        rankRepository.save(bronzeRank);
        rankRepository.save(silverRank);
        rankRepository.save(goldRank);

        UserRole userRoleAdmin = new UserRole(0, "ROLE_ADMIN", "Admin role");
        UserRole userRoleClient = new UserRole(1, "ROLE_CLIENT", "Client role");
        UserRole userRoleManager = new UserRole(2, "ROLE_MANAGER", "Manager role");
        userRoleRepository.save(userRoleAdmin);
        userRoleRepository.save(userRoleClient);
        userRoleRepository.save(userRoleManager);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        AdminUser adminUser = new AdminUser();
        adminUser.setEmail("admin");
        adminUser.setUsername("admin");
        adminUser.setPass(Hasher.hashPassword("admin"));
        adminUser.setPhone_number("+381603789663");
        adminUser.setDate_of_birth(simpleDateFormat.parse("2001-08-17"));
        adminUser.setFirst_name("Lazar");
        adminUser.setLast_name("Bojanic");
        adminUser.setEnabled("yes");

        adminUserRepository.save(adminUser);*/
    }
}