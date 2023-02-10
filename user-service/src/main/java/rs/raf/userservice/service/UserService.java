package rs.raf.userservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import rs.raf.core.dto.userservice.base.*;
import rs.raf.core.dto.userservice.view.UserStatusViewDto;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

public interface UserService {
    List<ServiceUserDto> getAllUsers();
    ServiceUserDto getUserById(Long id);
    ServiceUserDto getUserByEmail(String email);
    void deleteUser(Long id);
    List<ServiceUserDto> getAllAdminUsers();
    ServiceUserDto getAdminUserById(Long id);
    MessageDto requestAdminUserPasswordChange(Long id) throws JsonProcessingException;
    ServiceUserDto createAdminUser(AdminUserDto adminUserDto);
    ServiceUserDto registerAdminUser(AdminUserDto adminUserDto);
    TokenDto loginAdminUser(LoginUserDto loginUserDto);
    ServiceUserDto changeAdminUserPassword(Long userId, ChangePasswordDto changePasswordDto);
    ServiceUserDto updateAdminUser(Long id, AdminUserDto adminUserDto);
    MessageDto setUserEnabledState(UserEnabledDto userEnabledDto);
    void deleteAdminUser(Long id);


    List<ServiceUserDto> getAllClientUsers();
    ServiceUserDto getClientUserById(Long id);
    MessageDto requestClientUserPasswordChange(Long id) throws JsonProcessingException;
    ServiceUserDto createClientUser(ClientUserDto clientUserDto) throws NoSuchAlgorithmException, InvalidKeySpecException, JsonProcessingException;
    MessageDto confirmClientUserRegistration(String token) throws NoSuchAlgorithmException, InvalidKeySpecException, JsonProcessingException;
    ServiceUserDto registerClientUser(ClientUserDto clientUserDto) throws  NoSuchAlgorithmException, InvalidKeySpecException, JsonProcessingException;
    TokenDto loginClientUser(LoginUserDto loginUserDto) throws NoSuchAlgorithmException, InvalidKeySpecException;
    ServiceUserDto changeClientUserPassword(Long userId, ChangePasswordDto changePasswordDto);
    ServiceUserDto updateClientUser(Long id, ClientUserDto clientUserDto);
    void deleteClientUser(Long id);

    List<ServiceUserDto> getAllManagerUsers();
    ServiceUserDto getManagerUserById(Long id);
    MessageDto requestManagerUserPasswordChange(Long id) throws JsonProcessingException;
    ServiceUserDto createManagerUser(ManagerUserDto managerUserDto);
    MessageDto confirmManagerUserRegistration(String token) throws NoSuchAlgorithmException, InvalidKeySpecException, JsonProcessingException;
    ServiceUserDto registerManagerUser(ManagerUserDto managerUserDto) throws  JsonProcessingException;
    TokenDto loginManagerUser(LoginUserDto loginUserDto);
    ServiceUserDto changeManagerUserPassword(Long userId, ChangePasswordDto changePasswordDto);
    ServiceUserDto updateManagerUser(Long id, ManagerUserDto managerUserDto);
    void deleteManagerUser(Long id);







    List<UserStatusViewDto> getAllUserStatuses();
    UserStatusViewDto getUserStatusByUserId(Long userId);
    UserStatusViewDto createUserStatus(UserStatusDto userStatusDto);
    UserStatusViewDto updateUserStatusByUserId(Long userId, UserStatusDto userStatusDto);
    void deleteUserStatusByUserId(Long userId);
}