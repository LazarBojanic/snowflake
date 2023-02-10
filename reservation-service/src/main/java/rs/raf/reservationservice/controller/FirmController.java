package rs.raf.reservationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rs.raf.core.dto.reservationservice.base.FirmDto;
import rs.raf.core.dto.reservationservice.base.VehicleDto;
import rs.raf.core.dto.reservationservice.view.FirmViewDto;
import rs.raf.core.util.DefinedRoleListFactory;
import rs.raf.reservationservice.security.service.TokenService;
import rs.raf.reservationservice.service.ReservationService;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/firm")
public class FirmController {
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private TokenService tokenService;

    @GetMapping("/getAll")
    public ResponseEntity<List<FirmViewDto>> getAllFirms(@RequestHeader("Authorization") String bearerToken){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(reservationService.getAllFirms(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<FirmViewDto> getFirmById(@RequestHeader("Authorization") String bearerToken, @PathVariable Long id){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(reservationService.getFirmById(id), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @GetMapping("/getByName/{firmName}")
    public ResponseEntity<FirmViewDto> getFirmById(@RequestHeader("Authorization") String bearerToken, @PathVariable String firmName){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(reservationService.getFirmByName(firmName), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @PostMapping("/create")
    public ResponseEntity<FirmViewDto> createFirm(@RequestHeader("Authorization") String bearerToken, @RequestBody FirmDto firmDto){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, false, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(reservationService.createFirm(firmDto), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<FirmViewDto> updateFirm(@RequestHeader("Authorization") String bearerToken, @PathVariable Long id, @RequestBody FirmDto firmDto){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, false, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(reservationService.updateFirm(id, firmDto), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteVehicle(@RequestHeader("Authorization") String bearerToken, @PathVariable Long id){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, false, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            reservationService.deleteFirm(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
