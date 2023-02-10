package rs.raf.reservationservice.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.raf.core.dto.reservationservice.base.ReservationDto;
import rs.raf.core.dto.reservationservice.base.VehicleDto;
import rs.raf.core.dto.reservationservice.view.ReservationViewDto;
import rs.raf.core.dto.reservationservice.view.VehicleViewDto;
import rs.raf.core.util.DefinedRoleListFactory;
import rs.raf.reservationservice.security.service.TokenService;
import rs.raf.reservationservice.service.ReservationService;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/reservation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private TokenService tokenService;

    @GetMapping("/getAll")
    public ResponseEntity<List<ReservationViewDto>> getAlLReservations(@RequestHeader("Authorization") String bearerToken){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, false);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(reservationService.getAllReservations(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @GetMapping("/getAllByClientUserId/{clientUserId}")
    public ResponseEntity<List<ReservationViewDto>> getAllReservationsByClientUserId(@RequestHeader("Authorization") String bearerToken, @PathVariable Long clientUserId){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(reservationService.getAllReservationsByClientUserId(clientUserId), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @GetMapping("/getAllByVehicleInFirmId/{vehicleInFirmId}")
    public ResponseEntity<List<ReservationViewDto>> getAllReservationsByVehicleInFirmId(@RequestHeader("Authorization") String bearerToken, @PathVariable Long vehicleInFirmId){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(reservationService.getAllReservationsByVehicleInFirmId(vehicleInFirmId), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<ReservationViewDto> getReservationById(@RequestHeader("Authorization") String bearerToken, @PathVariable Long id){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, false);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(reservationService.getReservationById(id), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/getByClientUserIdAndVehicleInFirmId/{clientUserId}/{vehicleInFirmId}")
    public ResponseEntity<ReservationViewDto> getReservationByClientUserIdAndVehicleInFirmId(@RequestHeader("Authorization") String bearerToken, @PathVariable Long clientUserId, @PathVariable Long vehicleInFirmId){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, false);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(reservationService.getReservationByClientUserIdAndVehicleInFirmId(clientUserId, vehicleInFirmId), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @PostMapping("/create")
    public ResponseEntity<ReservationViewDto> createReservation(@RequestHeader("Authorization") String bearerToken, @RequestBody ReservationDto reservationDto){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, false);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(reservationService.createReservation(reservationDto), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ReservationViewDto> updateReservation(@RequestHeader("Authorization") String bearerToken, @PathVariable Long id, @RequestBody ReservationDto reservationDto){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, false);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(reservationService.updateReservation(id, reservationDto), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @PutMapping("/updateByClientUserIdAndVehicleInFirmId/{clientUserId}/{vehicleInFirmId}")
    public ResponseEntity<ReservationViewDto> updateReservationByClientUserIdAndVehicleInFirmId(@RequestHeader("Authorization") String bearerToken, @PathVariable Long clientUserId, @PathVariable Long vehicleInFirmId, @RequestBody ReservationDto reservationDto){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, false);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(reservationService.updateReservationByClientUserIdAndVehicleInFirmId(clientUserId, vehicleInFirmId, reservationDto), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteReservation(@RequestHeader("Authorization") String bearerToken, @PathVariable Long id){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, false);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            reservationService.deleteReservation(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @DeleteMapping("/deleteByClientUserIdAndVehicleInFirmId/{clientUserId}/{vehicleInFirmId}")
    public ResponseEntity<?> deleteReservationByClientUserIdAndVehicleInFirmId(@RequestHeader("Authorization") String bearerToken, @PathVariable Long clientUserId, @PathVariable Long vehicleInFirmId){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, false);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            reservationService.deleteReservationByClientUserIdAndVehicleInFirmId(clientUserId, vehicleInFirmId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
