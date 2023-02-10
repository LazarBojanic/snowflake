package rs.raf.userservice.controller;

import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.raf.core.dto.userservice.base.*;
import rs.raf.core.dto.userservice.view.UserStatusViewDto;
import rs.raf.core.util.DefinedRoleListFactory;
import rs.raf.userservice.security.service.TokenService;
import rs.raf.userservice.service.UserService;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

@RestController
@RequestMapping("/user_status")
public class UserStatusController {
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;

    @GetMapping("/getAll")
    public ResponseEntity<List<UserStatusViewDto>> getAllUserStatuses(@RequestHeader("Authorization") String bearerToken) {
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, false);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(userService.getAllUserStatuses(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @GetMapping("/get/{userId}")
    public ResponseEntity<UserStatusViewDto> getUserStatusByUserId(@PathVariable Long userId, @RequestHeader("Authorization") String bearerToken){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(userService.getUserStatusByUserId(userId), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @PostMapping("/create")
    public ResponseEntity<UserStatusViewDto> createUserStatus(@RequestBody UserStatusDto userStatusDto, @RequestHeader("Authorization") String bearerToken) throws NoSuchAlgorithmException, InvalidKeySpecException {
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, false);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(userService.createUserStatus(userStatusDto), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<UserStatusViewDto> updateUserStatusByUserId(@PathVariable Long id, @RequestBody UserStatusDto userStatusDto, @RequestHeader("Authorization") String bearerToken){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, false);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(userService.updateUserStatusByUserId(id, userStatusDto), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUserStatusByUserId(@RequestHeader("Authorization") String bearerToken, @PathVariable Long id){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, false);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            userService.deleteUserStatusByUserId(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}