package rs.raf.userservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.raf.core.dto.userservice.base.*;
import rs.raf.core.util.DefinedRoleListFactory;
import rs.raf.userservice.security.service.TokenService;
import rs.raf.userservice.service.UserService;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

@RestController
@RequestMapping("/user/manager")
public class ManagerUserController {
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;
    @GetMapping("/getAll")
    public ResponseEntity<List<ServiceUserDto>> getAllManagerUsers(@RequestHeader("Authorization") String bearerToken){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(userService.getAllManagerUsers(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<ServiceUserDto> getManagerUserById(@PathVariable Long id, @RequestHeader("Authorization") String bearerToken){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(userService.getManagerUserById(id), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @GetMapping("/requestPasswordChange/{id}")
    public ResponseEntity<MessageDto> requestManagerUserPasswordChange(@RequestHeader("Authorization") String bearerToken, @PathVariable Long id) throws JsonProcessingException {
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(false, false, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, id)){
            return new ResponseEntity<>(userService.requestManagerUserPasswordChange(id), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @PostMapping("/create")
    public ResponseEntity<ServiceUserDto> createManagerUser(@RequestBody ManagerUserDto managerUserDto, @RequestHeader("Authorization") String bearerToken){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, false, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(userService.createManagerUser(managerUserDto), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @GetMapping("/register/confirm/{token}")
    public ResponseEntity<MessageDto> registerManagerUser(@PathVariable String token) throws NoSuchAlgorithmException, InvalidKeySpecException, JsonProcessingException {
        MessageDto messageDto = userService.confirmManagerUserRegistration(token);
        if(messageDto.getMessage().equals("Registration Confirmation Successful")){
            return new ResponseEntity<>(messageDto, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(messageDto, HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/register")
    public ResponseEntity<ServiceUserDto> registerManagerUser(@RequestBody ManagerUserDto managerUserDto, @RequestHeader("Authorization") String bearerToken) throws AuthenticationException, JsonProcessingException {
        return new ResponseEntity<>(userService.registerManagerUser(managerUserDto), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> loginManagerUser(@RequestBody LoginUserDto loginUserDto, @RequestHeader("Authorization") String bearerToken){
        return new ResponseEntity<>(userService.loginManagerUser(loginUserDto), HttpStatus.OK);

    }
    @PostMapping("/changePassword/{id}")
    public ResponseEntity<ServiceUserDto> changeManagerUserPassword(@RequestHeader("Authorization") String bearerToken, @PathVariable Long id, @RequestBody ChangePasswordDto changePasswordDto){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(false, false, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, id)){
            return new ResponseEntity<>(userService.changeManagerUserPassword(id, changePasswordDto), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ServiceUserDto> updateManagerUser(@PathVariable Long id, @RequestBody ManagerUserDto managerUserDto, @RequestHeader("Authorization") String bearerToken){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(false, false, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, id)){
            return new ResponseEntity<>(userService.updateManagerUser(id, managerUserDto), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteManagerUser(@PathVariable Long id, @RequestHeader("Authorization") String bearerToken){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, false, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, id)){
            userService.deleteManagerUser(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}