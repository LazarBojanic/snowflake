package rs.raf.userservice.mapper;

import org.springframework.stereotype.Component;
import rs.raf.core.dto.userservice.base.AdminUserDto;
import rs.raf.core.dto.userservice.base.ClientUserDto;
import rs.raf.core.dto.userservice.base.ManagerUserDto;
import rs.raf.core.dto.userservice.base.ServiceUserDto;
import rs.raf.userservice.domain.*;

@Component
public class ServiceUserMapper {

    public AdminUser adminUserDtoToAdminUser(AdminUserDto adminUserDto){
        return new AdminUser(
                adminUserDto.getId(),
                adminUserDto.getUsername(),
                adminUserDto.getPass(),
                adminUserDto.getEmail(),
                adminUserDto.getPhone_number(),
                adminUserDto.getDate_of_birth(),
                adminUserDto.getFirst_name(),
                adminUserDto.getLast_name(),
                adminUserDto.getEnabled()
        );
    }
    public ServiceUserDto adminUserToServiceUserDto(AdminUser adminUser){
        return ServiceUserDto.builder()
                .id(adminUser.getId())
                .user_role_id(0)
                .username(adminUser.getUsername())
                .pass(adminUser.getPass())
                .email(adminUser.getEmail())
                .phone_number(adminUser.getPhone_number())
                .date_of_birth(adminUser.getDate_of_birth())
                .first_name(adminUser.getFirst_name())
                .last_name(adminUser.getLast_name())
                .passport_number(null)
                .hire_date(null)
                .firm_id(null)
                .enabled(adminUser.getEnabled())
                .build();
    }
    public ServiceUserDto adminUserDtoToServiceUserDto(AdminUserDto adminUserDto){
        return ServiceUserDto.builder()
                .id(adminUserDto.getId())
                .user_role_id(2)
                .username(adminUserDto.getUsername())
                .email(adminUserDto.getEmail())
                .pass(adminUserDto.getPass())
                .phone_number(adminUserDto.getPhone_number())
                .date_of_birth(adminUserDto.getDate_of_birth())
                .first_name(adminUserDto.getFirst_name())
                .last_name(adminUserDto.getLast_name())
                .passport_number(null)
                .firm_id(null)
                .hire_date(null)
                .enabled(adminUserDto.getEnabled())
                .build();
    }
    public ServiceUserDto clientUserDtoToServiceUserDto(ClientUserDto clientUserDto){
        return ServiceUserDto.builder()
                .id(clientUserDto.getId())
                .user_role_id(1)
                .username(clientUserDto.getUsername())
                .email(clientUserDto.getEmail())
                .pass(clientUserDto.getPass())
                .phone_number(clientUserDto.getPhone_number())
                .date_of_birth(clientUserDto.getDate_of_birth())
                .first_name(clientUserDto.getFirst_name())
                .last_name(clientUserDto.getLast_name())
                .passport_number(clientUserDto.getPassport_number())
                .firm_id(0L)
                .hire_date(null)
                .enabled(clientUserDto.getEnabled())
                .build();
    }
    public ClientUser clientUserDtoToClientUser(ClientUserDto clientUserDto){
        return new ClientUser(
                clientUserDto.getId(),
                clientUserDto.getEmail(),
                clientUserDto.getUsername(),
                clientUserDto.getPass(),
                clientUserDto.getPhone_number(),
                clientUserDto.getDate_of_birth(),
                clientUserDto.getFirst_name(),
                clientUserDto.getLast_name(),
                clientUserDto.getEnabled(),
                clientUserDto.getPassport_number()
        );
    }
    public ServiceUserDto clientUserToServiceUserDto(ClientUser clientUser){
         return ServiceUserDto.builder().
                 id(clientUser.getId())
                .user_role_id(1)
                .username(clientUser.getUsername())
                .email(clientUser.getEmail())
                .pass(clientUser.getPass())
                .phone_number(clientUser.getPhone_number())
                .date_of_birth(clientUser.getDate_of_birth())
                .first_name(clientUser.getFirst_name())
                .last_name(clientUser.getLast_name())
                .passport_number(clientUser.getPassport_number())
                .firm_id(0L)
                .hire_date(null)
                .enabled(clientUser.getEnabled())
                .build();
    }
    public ClientUserDto clientUserToClientUserDto(ClientUser clientUser){
        return ClientUserDto.builder()
                .id(clientUser.getId())
                .user_role_id(1)
                .username(clientUser.getUsername())
                .email(clientUser.getEmail())
                .pass(clientUser.getPass())
                .phone_number(clientUser.getPhone_number())
                .date_of_birth(clientUser.getDate_of_birth())
                .first_name(clientUser.getFirst_name())
                .last_name(clientUser.getLast_name())
                .passport_number(clientUser.getPassport_number())
                .enabled(clientUser.getEnabled())
                .build();
    }
    public ManagerUser managerUserDtoToManagerUser(ManagerUserDto managerUserDto){
        return new ManagerUser(
                managerUserDto.getId(),
                managerUserDto.getEmail(),
                managerUserDto.getUsername(),
                managerUserDto.getPass(),
                managerUserDto.getPhone_number(),
                managerUserDto.getDate_of_birth(),
                managerUserDto.getFirst_name(),
                managerUserDto.getLast_name(),
                managerUserDto.getEnabled(),
                managerUserDto.getFirm_id(),
                managerUserDto.getHire_date()
        );
    }
    public ServiceUserDto managerUserDtoToServiceUserDto(ManagerUserDto managerUserDto){
        return ServiceUserDto.builder()
                .id(managerUserDto.getId())
                .user_role_id(2)
                .username(managerUserDto.getUsername())
                .email(managerUserDto.getEmail())
                .pass(managerUserDto.getPass())
                .phone_number(managerUserDto.getPhone_number())
                .date_of_birth(managerUserDto.getDate_of_birth())
                .first_name(managerUserDto.getFirst_name())
                .last_name(managerUserDto.getLast_name())
                .firm_id(managerUserDto.getFirm_id())
                .hire_date(managerUserDto.getHire_date())
                .enabled(managerUserDto.getEnabled())
                .build();
    }
    public ServiceUserDto managerUserToServiceUserDto(ManagerUser managerUser){
        return ServiceUserDto.builder()
                .id(managerUser.getId())
                .user_role_id(2)
                .username(managerUser.getUsername())
                .email(managerUser.getEmail())
                .pass(managerUser.getPass())
                .phone_number(managerUser.getPhone_number())
                .date_of_birth(managerUser.getDate_of_birth())
                .first_name(managerUser.getFirst_name())
                .last_name(managerUser.getLast_name())
                .firm_id(managerUser.getFirm_id())
                .hire_date(managerUser.getHire_date())
                .enabled(managerUser.getEnabled())
                .build();
    }
}
