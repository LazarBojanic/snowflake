package rs.raf.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.raf.core.dto.userservice.base.ServiceUserDto;
import rs.raf.core.util.DefinedRoleListFactory;
import rs.raf.userservice.security.service.TokenService;
import rs.raf.userservice.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/service_user")
public class ServiceUserController {
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;
    @GetMapping("/getAll")
    public ResponseEntity<List<ServiceUserDto>> getAllUsers(@RequestHeader("Authorization") String bearerToken){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<ServiceUserDto> getUserById(@PathVariable Long id, @RequestHeader("Authorization") String bearerToken){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<ServiceUserDto> getUserByEmail(@PathVariable String email, @RequestHeader("Authorization") String bearerToken){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id, @RequestHeader("Authorization") String bearerToken){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, false, false);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.OK);        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}