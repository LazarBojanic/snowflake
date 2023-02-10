package rs.raf.userservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.jsonwebtoken.Claims;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;
import rs.raf.core.dto.userservice.base.*;
import rs.raf.core.util.DefinedRoleListFactory;
import rs.raf.userservice.security.service.TokenService;
import rs.raf.userservice.service.UserService;

import javax.jms.Queue;
import java.util.List;

@RestController
@RequestMapping("/user/admin")
public class AdminUserController {
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;

    @GetMapping("/getAll")
    public ResponseEntity<List<ServiceUserDto>> getAllAdminUsers(@RequestHeader("Authorization") String bearerToken) throws JsonProcessingException {
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, false, false);

        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(userService.getAllAdminUsers(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<ServiceUserDto> getAdminUserById(@RequestHeader("Authorization") String bearerToken, @PathVariable Long id){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, false, false);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(userService.getAdminUserById(id), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @GetMapping("/requestPasswordChange/{id}")
    public ResponseEntity<MessageDto> requestAdminUserPasswordChange(@RequestHeader("Authorization") String bearerToken, @PathVariable Long id) throws JsonProcessingException {
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, false, false);
        if(tokenService.checkSecurity(bearerToken, definedRoles, id)){
            return new ResponseEntity<>(userService.requestAdminUserPasswordChange(id), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @PostMapping("/create")
    public ResponseEntity<ServiceUserDto> createAdminUser(@RequestHeader("Authorization") String bearerToken, @RequestBody AdminUserDto adminUserDto){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, false, false);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(userService.createAdminUser(adminUserDto), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @PostMapping("/register")
    public ResponseEntity<ServiceUserDto> registerAdminUser(@RequestHeader("Authorization") String bearerToken, @RequestBody AdminUserDto adminUserDto) throws AuthenticationException {
        return new ResponseEntity<>(userService.registerAdminUser(adminUserDto), HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity<TokenDto> loginAdminUser(@RequestHeader("Authorization") String bearerToken, @RequestBody LoginUserDto loginUserDto){
        return new ResponseEntity<>(userService.loginAdminUser(loginUserDto), HttpStatus.OK);
    }
    @PutMapping("/setUserEnabledState")
    public ResponseEntity<MessageDto> setUserEnabledState(@RequestHeader("Authorization") String bearerToken, @RequestBody UserEnabledDto userEnabledDto){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, false, false);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(userService.setUserEnabledState(userEnabledDto), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @PostMapping("/changePassword/{id}")
    public ResponseEntity<ServiceUserDto> changeAdminUserPassword(@RequestHeader("Authorization") String bearerToken, @PathVariable Long id, @RequestBody ChangePasswordDto changePasswordDto){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, false, false);
        if(tokenService.checkSecurity(bearerToken, definedRoles, id)){
            return new ResponseEntity<>(userService.changeAdminUserPassword(id, changePasswordDto), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ServiceUserDto> updateAdminUser(@RequestHeader("Authorization") String bearerToken, @PathVariable Long id, @RequestBody AdminUserDto adminUserDto){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, false, false);
        if(tokenService.checkSecurity(bearerToken, definedRoles, id)){
            return new ResponseEntity<>(userService.updateAdminUser(id, adminUserDto), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAdminUser(@RequestHeader("Authorization") String bearerToken, @PathVariable Long id){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, false, false);
        if(tokenService.checkSecurity(bearerToken, definedRoles, id)){
            userService.deleteAdminUser(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}