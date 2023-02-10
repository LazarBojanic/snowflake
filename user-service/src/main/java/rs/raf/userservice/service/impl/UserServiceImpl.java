package rs.raf.userservice.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import rs.raf.core.dto.notificationservice.base.ChangePasswordNotificationDto;
import rs.raf.core.dto.notificationservice.base.NotificationDto;
import rs.raf.core.dto.notificationservice.base.RegistrationConfirmationNotificationDto;
import rs.raf.core.dto.userservice.base.*;
import rs.raf.core.dto.userservice.view.UserStatusViewDto;
import rs.raf.userservice.domain.*;
import rs.raf.userservice.mapper.ServiceUserMapper;
import rs.raf.userservice.mapper.UserStatusMapper;
import rs.raf.userservice.repository.*;
import rs.raf.userservice.security.Hasher;
import rs.raf.userservice.security.service.TokenService;
import rs.raf.userservice.service.UserService;
import rs.raf.userservice.util.Util;

import javax.jms.Queue;
import javax.transaction.Transactional;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@NoArgsConstructor
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository<ServiceUser> userRepository;
    @Autowired
    private AdminUserRepository adminUserRepository;
    @Autowired
    private ClientUserRepository clientUserRepository;
    @Autowired
    private ManagerUserRepository managerUserRepository;
    @Autowired
    private ServiceUserMapper serviceUserMapper;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserStatusRepository userStatusRepository;
    @Autowired
    private RankRepository rankRepository;
    @Autowired
    private UserStatusMapper userStatusMapper;
    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private Queue registrationConfirmationNotification;
    @Autowired
    private Queue changePasswordNotification;


    @Override
    public List<ServiceUserDto> getAllUsers() {
        List<ServiceUserDto> serviceUserDtoList = new ArrayList<>();
        List<AdminUser> adminUserList = adminUserRepository.findAll();
        List<ClientUser> clientUserList = clientUserRepository.findAll();
        List<ManagerUser> managerUserList = managerUserRepository.findAll();
        for(AdminUser adminUser : adminUserList){
            serviceUserDtoList.add(serviceUserMapper.adminUserToServiceUserDto(adminUser));
        }
        for(ClientUser clientUser : clientUserList){
            serviceUserDtoList.add(serviceUserMapper.clientUserToServiceUserDto(clientUser));
        }
        for(ManagerUser managerUser : managerUserList){
            serviceUserDtoList.add(serviceUserMapper.managerUserToServiceUserDto(managerUser));
        }
        /*List<ServiceUser> serviceUserList = userRepository.getAll();
        for(ServiceUser serviceUser : serviceUserList){
            serviceUserDtoList.add(serviceUserMapper.serviceUserToServiceUserDto(serviceUser));
        }*/
        return serviceUserDtoList;
    }
    @Override
    public ServiceUserDto getUserById(Long id) {
        if(adminUserRepository.findById(id).isPresent()){
            return serviceUserMapper.adminUserToServiceUserDto(adminUserRepository.findById(id).get());
        }
        if(clientUserRepository.findById(id).isPresent()){
            return serviceUserMapper.clientUserToServiceUserDto(clientUserRepository.findById(id).get());
        }
        if(managerUserRepository.findById(id).isPresent()){
            return serviceUserMapper.managerUserToServiceUserDto(managerUserRepository.findById(id).get());
        }
        return null;
    }

    @Override
    public ServiceUserDto getUserByEmail(String email) {
        if(adminUserRepository.findAdminUserByEmail(email) != null){
            return serviceUserMapper.adminUserToServiceUserDto(adminUserRepository.findAdminUserByEmail(email));
        }
        if(clientUserRepository.findClientUserByEmail(email) != null){
            return serviceUserMapper.clientUserToServiceUserDto(clientUserRepository.findClientUserByEmail(email));
        }
        if(managerUserRepository.findManagerUserByEmail(email) != null){
            return serviceUserMapper.managerUserToServiceUserDto(managerUserRepository.findManagerUserByEmail(email));
        }
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


    @Override
    public List<ServiceUserDto> getAllAdminUsers() {
        List<AdminUser> adminUserList = adminUserRepository.findAll();
        List<ServiceUserDto> serviceUserDtoList = new ArrayList<>();
        for(AdminUser adminUser : adminUserList){
            serviceUserDtoList.add(serviceUserMapper.adminUserToServiceUserDto(adminUser));
        }
        return serviceUserDtoList;
    }
    @Override
    public ServiceUserDto getAdminUserById(Long id) {
        if(adminUserRepository.findById(id).isPresent()){
            return serviceUserMapper.adminUserToServiceUserDto(adminUserRepository.findById(id).get());
        }
        return null;
    }

    @Override
    public MessageDto requestAdminUserPasswordChange(Long id) throws JsonProcessingException {
        Optional<AdminUser> optionalAdminUser = adminUserRepository.findById(id);
        if(optionalAdminUser.isPresent()){
            AdminUser adminUser = optionalAdminUser.get();
            Claims claims = Jwts.claims();
            claims.put("id", adminUser.getId());
            claims.put("email", adminUser.getEmail());
            claims.put("allowPasswordChange", "yes");
            TokenDto tokenDto = new TokenDto(tokenService.generate(claims));
            ChangePasswordNotificationDto changePasswordNotificationDto = new ChangePasswordNotificationDto(adminUser.getEmail(), adminUser.getFirst_name(), adminUser.getLast_name(), tokenDto.getToken());
            String notificationJson = Util.objectToJson(changePasswordNotificationDto);
            jmsTemplate.convertAndSend(changePasswordNotification, notificationJson);
            return new MessageDto("Success");
        }
        return null;
    }

    @Override
    public ServiceUserDto createAdminUser(AdminUserDto adminUserDto) {
        return registerAdminUser(adminUserDto);
    }
    @Override
    public ServiceUserDto registerAdminUser(AdminUserDto adminUserDto)   {
        if(adminUserRepository.findAdminUserByEmail(adminUserDto.getEmail()) != null){
            return null;
        }
        else{
            String hashedPass = Hasher.hashPassword(adminUserDto.getPass());
            System.out.println(hashedPass);
            adminUserDto.setPass(hashedPass);
            adminUserDto.setEnabled("yes");
            adminUserRepository.save(serviceUserMapper.adminUserDtoToAdminUser(adminUserDto));
        }
        return serviceUserMapper.adminUserDtoToServiceUserDto(adminUserDto);
    }
    @Override
    public TokenDto loginAdminUser(LoginUserDto loginUserDto) {
        AdminUser adminUser = adminUserRepository.findAdminUserByEmail(loginUserDto.getEmail());
        if(adminUser == null){
            return null;
        }
        else{
            if(Hasher.checkPassword(loginUserDto.getPass(), adminUser.getPass())){
                Claims claims = Jwts.claims();
                claims.put("id", adminUser.getId());
                claims.put("role_id", "0");
                claims.put("email", loginUserDto.getEmail());
                claims.put("enabled", "yes");
                TokenDto tokenDto = new TokenDto(tokenService.generate(claims));
                System.out.println(tokenDto.getToken());
                return tokenDto;
            }
            else{
                return null;
            }
        }
    }
    @Override
    public ServiceUserDto updateAdminUser(Long id, AdminUserDto adminUserDto) {
        if(adminUserRepository.findById(id).isPresent()){
            AdminUser adminUser = adminUserRepository.findById(id).get();
            adminUser.setUsername(adminUserDto.getUsername());
            adminUser.setEmail(adminUserDto.getEmail());
            adminUser.setPass(adminUserDto.getPass());
            adminUser.setDate_of_birth(adminUserDto.getDate_of_birth());
            adminUser.setFirst_name(adminUserDto.getFirst_name());
            adminUser.setLast_name(adminUserDto.getLast_name());
            return serviceUserMapper.adminUserDtoToServiceUserDto(adminUserDto);
        }
        return null;
    }

    @Override
    public ServiceUserDto changeAdminUserPassword(Long userId, ChangePasswordDto changePasswordDto) {
        Optional<AdminUser> optionalAdminUser = adminUserRepository.findById(userId);
        if(optionalAdminUser.isPresent()){
            AdminUser adminUser = optionalAdminUser.get();
            if(Hasher.checkPassword(changePasswordDto.getOldPass(), adminUser.getPass())){
                adminUser.setPass(changePasswordDto.getNewPass());
                return serviceUserMapper.adminUserToServiceUserDto(adminUserRepository.save(adminUser));
            }
            return null;
        }
        return null;
    }

    @Override
    public MessageDto setUserEnabledState(UserEnabledDto userEnabledDto) {
        if(userEnabledDto.getEnabled() != null){
            Optional<ServiceUser> optionalServiceUser = userRepository.findById(userEnabledDto.getUserId());
            if(optionalServiceUser.isPresent()){
                ServiceUser serviceUser = optionalServiceUser.get();
                serviceUser.setEnabled(userEnabledDto.getEnabled());
                userRepository.save(serviceUser);
                return new MessageDto("User updated successfully");
            }
            else{
                return null;
            }
        }
        return null;
    }

    @Override
    public void deleteAdminUser(Long id) {
        adminUserRepository.deleteById(id);
    }

    @Override
    public List<ServiceUserDto> getAllClientUsers() {
        List<ClientUser> clientUserList = clientUserRepository.findAll();
        List<ServiceUserDto> serviceUserDtoList = new ArrayList<>();
        for(ClientUser clientUser : clientUserList){
            serviceUserDtoList.add(serviceUserMapper.clientUserToServiceUserDto(clientUser));
        }
        return serviceUserDtoList;
    }
    @Override
    public ServiceUserDto getClientUserById(Long id) {
        if(clientUserRepository.findById(id).isPresent()){
            return serviceUserMapper.clientUserToServiceUserDto(clientUserRepository.findById(id).get());
        }
        return null;
    }

    @Override
    public MessageDto requestClientUserPasswordChange(Long id) throws JsonProcessingException {
        Optional<ClientUser> optionalClientUser = clientUserRepository.findById(id);
        if(optionalClientUser.isPresent()){
            ClientUser clientUser = optionalClientUser.get();
            Claims claims = Jwts.claims();
            claims.put("id", clientUser.getId());
            claims.put("email", clientUser.getEmail());
            claims.put("allowPasswordChange", "yes");
            TokenDto tokenDto = new TokenDto(tokenService.generate(claims));
            ChangePasswordNotificationDto changePasswordNotificationDto = new ChangePasswordNotificationDto(clientUser.getEmail(), clientUser.getFirst_name(), clientUser.getLast_name(), tokenDto.getToken());
            String notificationJson = Util.objectToJson(changePasswordNotificationDto);
            jmsTemplate.convertAndSend(changePasswordNotification, notificationJson);
            return new MessageDto("Success");
        }
        return null;
    }



    @Override
    public ServiceUserDto createClientUser(ClientUserDto clientUserDto) throws JsonProcessingException {
        return registerClientUser(clientUserDto);
    }

    @Override
    public MessageDto confirmClientUserRegistration(String token) throws  NoSuchAlgorithmException, InvalidKeySpecException, JsonProcessingException {
        Claims claims = tokenService.parseToken(token);
        Long userId = claims.get("id", Long.class);
        Optional<ClientUser> optionalClientUser = clientUserRepository.findById(userId);
        if(optionalClientUser.isPresent()){
            ClientUser clientUser = optionalClientUser.get();
            clientUser.setEnabled("yes");
            serviceUserMapper.clientUserToServiceUserDto(clientUserRepository.save(clientUser));
            return new MessageDto("Registration Confirmation Successful");
        }
        else{
            return new MessageDto("Registration Confirmation Failed");
        }
    }

    @Override
    public ServiceUserDto registerClientUser(ClientUserDto clientUserDto) throws JsonProcessingException {
        if(clientUserRepository.findClientUserByEmail(clientUserDto.getEmail()) != null){
            return null;
        }
        else{
            String hashedPass = Hasher.hashPassword(clientUserDto.getPass());
            System.out.println(hashedPass);
            clientUserDto.setPass(hashedPass);
            clientUserDto.setEnabled("no");
            ClientUser clientUser = clientUserRepository.save(serviceUserMapper.clientUserDtoToClientUser(clientUserDto));
            Rank rank = rankRepository.findRankByRank("bronze");
            userStatusRepository.save(new UserStatus(clientUser, rank, 0, 0, 0));

            Claims claims = Jwts.claims();
            claims.put("id", clientUser.getId());
            claims.put("role_id", "1");
            claims.put("enabled", "no");
            TokenDto tokenDto = new TokenDto(tokenService.generate(claims));

            RegistrationConfirmationNotificationDto registrationConfirmationNotificationDto = new RegistrationConfirmationNotificationDto(
                    clientUserDto.getEmail(),
                    clientUserDto.getFirst_name(),
                    clientUserDto.getLast_name(),
                    "http://95.180.97.206:8083/userservice/api/user/client/register/confirm/",
                    tokenDto.getToken()
                    );
            String notificationString = Util.objectToJson(registrationConfirmationNotificationDto);
            System.out.println(notificationString);
            jmsTemplate.convertAndSend(registrationConfirmationNotification, notificationString);
        }
        return serviceUserMapper.clientUserDtoToServiceUserDto(clientUserDto);
    }
    @Override
    public TokenDto loginClientUser(LoginUserDto loginUserDto) {
        ClientUser clientUser = clientUserRepository.findClientUserByEmail(loginUserDto.getEmail());
        if(clientUser == null){
            return null;
        }
        else{
            if(Hasher.checkPassword(loginUserDto.getPass(), clientUser.getPass())){
                Claims claims = Jwts.claims();
                claims.put("id", clientUser.getId());
                claims.put("role_id", "1");
                claims.put("email", loginUserDto.getEmail());
                claims.put("enabled", clientUser.getEnabled());
                TokenDto tokenDto = new TokenDto(tokenService.generate(claims));
                System.out.println(tokenDto.getToken());
                return tokenDto;
            }
            else{
                return null;
            }
        }
    }

    @Override
    public ServiceUserDto changeClientUserPassword(Long userId, ChangePasswordDto changePasswordDto) {
        Optional<ClientUser> optionalClientUser = clientUserRepository.findById(userId);
        if(optionalClientUser.isPresent()){
            ClientUser clientUser = optionalClientUser.get();
            if(Hasher.checkPassword(changePasswordDto.getOldPass(), clientUser.getPass())){
                clientUser.setPass(Hasher.hashPassword(changePasswordDto.getNewPass()));
                return serviceUserMapper.clientUserToServiceUserDto(clientUserRepository.save(clientUser));
            }
            return null;
        }
        return null;
    }



    @Override
    public ServiceUserDto updateClientUser(Long id, ClientUserDto clientUserDto) {
        Optional<ClientUser> optionalClientUser = clientUserRepository.findById(id);
        if(optionalClientUser.isPresent()){
            ClientUser clientUser = optionalClientUser.get();
            if(clientUserDto.getEmail() != null){
                clientUser.setEmail(clientUserDto.getEmail());
            }
            if(clientUserDto.getUsername() != null){
                clientUser.setUsername(clientUserDto.getUsername());
            }
            if(clientUserDto.getPass() != null){
                clientUser.setPass(Hasher.hashPassword(clientUserDto.getPass()));
            }
            if(clientUserDto.getPhone_number() != null){
                clientUser.setPhone_number(clientUserDto.getPhone_number());
            }
            if(clientUserDto.getDate_of_birth() != null){
                clientUser.setDate_of_birth(clientUserDto.getDate_of_birth());
            }
            if(clientUserDto.getFirst_name() != null){
                clientUser.setFirst_name(clientUserDto.getFirst_name());
            }
            if(clientUserDto.getLast_name() != null){
                clientUser.setLast_name(clientUserDto.getLast_name());
            }
            if(clientUserDto.getPassport_number() != null){
                clientUser.setPassport_number(clientUserDto.getPassport_number());
            }
            clientUserRepository.save(clientUser);
            return serviceUserMapper.clientUserToServiceUserDto(clientUser);
        }
        return null;
    }
    @Override
    public void deleteClientUser(Long id) {
        clientUserRepository.deleteById(id);
    }

    @Override
    public List<ServiceUserDto> getAllManagerUsers() {
        List<ManagerUser> managerUserList = managerUserRepository.findAll();
        List<ServiceUserDto> serviceUserDtoList = new ArrayList<>();
        for(ManagerUser managerUser : managerUserList){
            serviceUserDtoList.add(serviceUserMapper.managerUserToServiceUserDto(managerUser));
        }
        return serviceUserDtoList;
    }
    @Override
    public ServiceUserDto getManagerUserById(Long id) {
        if(managerUserRepository.findById(id).isPresent()){
            return serviceUserMapper.managerUserToServiceUserDto(managerUserRepository.findById(id).get());
        }
        return null;
    }
    @Override
    public MessageDto requestManagerUserPasswordChange(Long id) throws JsonProcessingException {
        Optional<ManagerUser> optionalManagerUser = managerUserRepository.findById(id);
        if(optionalManagerUser.isPresent()){
            ManagerUser managerUser = optionalManagerUser.get();
            Claims claims = Jwts.claims();
            claims.put("id", managerUser.getId());
            claims.put("email", managerUser.getEmail());
            claims.put("allowPasswordChange", "yes");
            TokenDto tokenDto = new TokenDto(tokenService.generate(claims));
            ChangePasswordNotificationDto changePasswordNotificationDto = new ChangePasswordNotificationDto(managerUser.getEmail(), managerUser.getFirst_name(), managerUser.getLast_name(), tokenDto.getToken());
            String notificationJson = Util.objectToJson(changePasswordNotificationDto);
            jmsTemplate.convertAndSend(changePasswordNotification, notificationJson);
            return new MessageDto("Success");
        }
        return null;
    }
    @Override
    public ServiceUserDto createManagerUser(ManagerUserDto managerUserDto) {
        ManagerUser managerUser = managerUserRepository.findManagerUserByEmail(managerUserDto.getEmail());
        if(managerUser != null){
            return null;
        }
        else{
            managerUserRepository.save(serviceUserMapper.managerUserDtoToManagerUser(managerUserDto));
        }
        return serviceUserMapper.managerUserDtoToServiceUserDto(managerUserDto);
    }

    @Override
    public MessageDto confirmManagerUserRegistration(String token) throws NoSuchAlgorithmException, InvalidKeySpecException, JsonProcessingException {
        Claims claims = tokenService.parseToken(token);
        Long userId = claims.get("id", Long.class);

        Optional<ManagerUser> optionalManagerUser = managerUserRepository.findById(userId);
        if(optionalManagerUser.isPresent()){
            ManagerUser managerUser = optionalManagerUser.get();
            managerUser.setEnabled("yes");
            serviceUserMapper.managerUserToServiceUserDto(managerUserRepository.save(managerUser));
            return new MessageDto("Registration Confirmation Successful");
        }
        else{
            return new MessageDto("Registration Confirmation Failed");
        }
    }

    @Override
    public ServiceUserDto registerManagerUser(ManagerUserDto managerUserDto) throws JsonProcessingException {
        if(managerUserRepository.findManagerUserByEmail(managerUserDto.getEmail()) != null){
            return null;
        }
        else{
            String hashedPass = Hasher.hashPassword(managerUserDto.getPass());
            System.out.println(hashedPass);
            managerUserDto.setPass(hashedPass);
            managerUserDto.setEnabled("no");
            ManagerUser managerUser = managerUserRepository.save(serviceUserMapper.managerUserDtoToManagerUser(managerUserDto));

            Claims claims = Jwts.claims();
            claims.put("id", managerUser.getId());
            claims.put("role_id", "1");
            claims.put("enabled", "no");
            TokenDto tokenDto = new TokenDto(tokenService.generate(claims));

            NotificationDto notificationDto = new NotificationDto(0, managerUserDto.getEmail(), "Registration Confirmation",
                    "Dear " + managerUser.getUsername() + ", Please click the following link to confirm your registration: http://95.180.97.206:8080/api/user/manager/register/confirm/" + tokenDto.getToken());
            String notificationString = Util.objectToJson(notificationDto);
            System.out.println(notificationString);
            jmsTemplate.convertAndSend(registrationConfirmationNotification, notificationString);
        }
        return serviceUserMapper.managerUserDtoToServiceUserDto(managerUserDto);
    }
    @Override
    public TokenDto loginManagerUser(LoginUserDto loginUserDto) {
        ManagerUser managerUser = managerUserRepository.findManagerUserByEmail(loginUserDto.getEmail());
        if(managerUser != null){
            if(Hasher.checkPassword(loginUserDto.getPass(), managerUser.getPass())){
                Claims claims = Jwts.claims();
                claims.put("id", managerUser.getId());
                claims.put("role_id", "2");
                claims.put("email", loginUserDto.getEmail());
                claims.put("enabled", managerUser.getEnabled());
                TokenDto tokenDto = new TokenDto(tokenService.generate(claims));
                System.out.println(tokenDto.getToken());
                return tokenDto;
            }
            else{
                return null;
            }
        }
        return null;
    }
    @Override
    public ServiceUserDto changeManagerUserPassword(Long userId, ChangePasswordDto changePasswordDto) {
        Optional<ManagerUser> optionalManagerUser = managerUserRepository.findById(userId);
        if(optionalManagerUser.isPresent()){
            ManagerUser managerUser = optionalManagerUser.get();
            if(Hasher.checkPassword(changePasswordDto.getOldPass(), managerUser.getPass())){
                managerUser.setPass(changePasswordDto.getNewPass());
                return serviceUserMapper.managerUserToServiceUserDto(managerUserRepository.save(managerUser));
            }
            return null;
        }
        return null;
    }
    @Override
    public ServiceUserDto updateManagerUser(Long id, ManagerUserDto managerUserDto) {
        if(managerUserRepository.findById(id).isPresent()){
            ManagerUser managerUser = managerUserRepository.findById(id).get();
            managerUser.setUsername(managerUserDto.getUsername());
            managerUser.setEmail(managerUserDto.getEmail());
            managerUser.setPass(managerUserDto.getPass());
            managerUser.setPhone_number(managerUserDto.getPhone_number());
            managerUser.setDate_of_birth(managerUserDto.getDate_of_birth());
            managerUser.setFirst_name(managerUserDto.getFirst_name());
            managerUser.setLast_name(managerUserDto.getLast_name());
            managerUser.setFirm_id(managerUserDto.getFirm_id());
            managerUser.setHire_date(managerUserDto.getHire_date());
            return serviceUserMapper.managerUserToServiceUserDto(managerUser);
        }
        return null;
    }
    @Override
    public void deleteManagerUser(Long id) {
        managerUserRepository.deleteById(id);
    }


    @Override
    public List<UserStatusViewDto> getAllUserStatuses() {
        List<UserStatus> userStatusList = userStatusRepository.findAll();
        List<UserStatusViewDto> userStatusViewDtoList = new ArrayList<>();
        for(UserStatus userStatus : userStatusList){
            userStatusViewDtoList.add(userStatusMapper.userStatusToUserStatusViewDto(userStatus));
        }
        return userStatusViewDtoList;
    }

    @Override
    public UserStatusViewDto getUserStatusByUserId(Long userId) {
        UserStatus userStatus = userStatusRepository.findUserStatusByClientUserId(userId);
        if(userStatus != null){
            return userStatusMapper.userStatusToUserStatusViewDto(userStatus);
        }
        return null;
    }

    @Override
    public UserStatusViewDto createUserStatus(UserStatusDto userStatusDto) {
        return userStatusMapper.userStatusToUserStatusViewDto(userStatusRepository.save(userStatusMapper.userStatusDtoToUserStatus(userStatusDto)));
    }

    @Override
    public UserStatusViewDto updateUserStatusByUserId(Long userId, UserStatusDto userStatusDto) {
        UserStatus userStatus = userStatusRepository.findUserStatusByClientUserId(userId);
        Optional<ClientUser> optionalClientUser = clientUserRepository.findById(userStatusDto.getClient_user_id());

        if(optionalClientUser.isPresent()){
            ClientUser clientUser = optionalClientUser.get();
            if(userStatusDto.getClient_user_id() != null){
                userStatus.setClient_user(clientUser);
            }
            if(userStatusDto.getRank_id() != null){
                Rank rank = rankRepository.findRankById(userStatusDto.getRank_id());
                userStatus.setRank(rank);
            }
            if(userStatusDto.getDiscount_percent() != null){
                userStatus.setDiscount_percent(userStatusDto.getDiscount_percent());
            }
            if(userStatusDto.getNumber_of_days_reserved() != null){
                userStatus.setNumber_of_days_reserved(userStatusDto.getNumber_of_days_reserved());
            }
            if(userStatusDto.getCurrent_number_of_reservations() != null){
                userStatus.setCurrent_number_of_reservations(userStatusDto.getCurrent_number_of_reservations());
            }
            return  userStatusMapper.userStatusToUserStatusViewDto(userStatusRepository.save(userStatus));
        }
        return null;
    }

    @Override
    public void deleteUserStatusByUserId(Long userId) {
        userStatusRepository.deleteById(userId);
    }
}
