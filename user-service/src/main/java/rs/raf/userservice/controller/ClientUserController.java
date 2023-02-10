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
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

@RestController
@RequestMapping("/user/client")
public class ClientUserController {
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;


    @GetMapping("/getAll")
    public ResponseEntity<List<ServiceUserDto>> getAllClientUsers(@RequestHeader("Authorization") String bearerToken) {
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(userService.getAllClientUsers(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<ServiceUserDto> getClientUserById(@PathVariable Long id, @RequestHeader("Authorization") String bearerToken){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(userService.getClientUserById(id), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @GetMapping("/requestPasswordChange/{id}")
    public ResponseEntity<MessageDto> requestClientUserPasswordChange(@RequestHeader("Authorization") String bearerToken, @PathVariable Long id) throws JsonProcessingException {
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(false, true, false);
        if(tokenService.checkSecurity(bearerToken, definedRoles, id)){
            return new ResponseEntity<>(userService.requestClientUserPasswordChange(id), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @PostMapping("/create")
    public ResponseEntity<ServiceUserDto> createClientUser(@RequestBody ClientUserDto clientUserDto, @RequestHeader("Authorization") String bearerToken) throws NoSuchAlgorithmException, InvalidKeySpecException, JsonProcessingException {
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, false);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(userService.createClientUser(clientUserDto), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @GetMapping("/register/confirm/{token}")
    public ResponseEntity<MessageDto> confirmClientUserRegistration(@PathVariable String token) throws AuthenticationException, NoSuchAlgorithmException, InvalidKeySpecException, JsonProcessingException {
        MessageDto messageDto = userService.confirmClientUserRegistration(token);
        if(messageDto.getMessage().equals("Registration Confirmation Successful")){
            return new ResponseEntity<>(messageDto, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(messageDto, HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/register")
    public ResponseEntity<ServiceUserDto> registerClientUser(@RequestBody ClientUserDto clientUserDto, @RequestHeader("Authorization") String bearerToken) throws AuthenticationException, NoSuchAlgorithmException, InvalidKeySpecException, JsonProcessingException {
        return new ResponseEntity<>(userService.registerClientUser(clientUserDto), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> loginClientUser(@RequestBody LoginUserDto loginUserDto, @RequestHeader("Authorization") String bearerToken) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return new ResponseEntity<>(userService.loginClientUser(loginUserDto), HttpStatus.OK);
    }
    @PostMapping("/changePassword/{id}")
    public ResponseEntity<ServiceUserDto> changeClientUserPassword(@RequestHeader("Authorization") String bearerToken, @PathVariable Long id, @RequestBody ChangePasswordDto changePasswordDto){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(false, true, false);
        if(tokenService.checkSecurity(bearerToken, definedRoles, id)){
            return new ResponseEntity<>(userService.changeClientUserPassword(id, changePasswordDto), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ServiceUserDto> updateClientUser(@PathVariable Long id, @RequestBody ClientUserDto clientUserDto, @RequestHeader("Authorization") String bearerToken){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(false, true, false);
        if(tokenService.checkSecurity(bearerToken, definedRoles, id)){
            return new ResponseEntity<>(userService.updateClientUser(id, clientUserDto), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteClientUser(@RequestHeader("Authorization") String bearerToken, @PathVariable Long id){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, false);
        if(tokenService.checkSecurity(bearerToken, definedRoles, id)){
            userService.deleteClientUser(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}