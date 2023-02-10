package rs.raf.reservationservice.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.raf.core.dto.reservationservice.base.VehicleModelDto;
import rs.raf.core.dto.reservationservice.base.VehicleTypeDto;
import rs.raf.core.dto.reservationservice.view.VehicleModelViewDto;
import rs.raf.core.dto.reservationservice.view.VehicleTypeViewDto;
import rs.raf.core.util.DefinedRoleListFactory;
import rs.raf.reservationservice.security.service.TokenService;
import rs.raf.reservationservice.service.ReservationService;

import java.util.List;
@RestController
@RequestMapping("/vehicle_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleTypeController {
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private TokenService tokenService;

    @GetMapping("/getAll")
    public ResponseEntity<List<VehicleTypeViewDto>> getAllVehicleTypes(@RequestHeader("Authorization") String bearerToken){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(reservationService.getAllVehicleTypes(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<VehicleTypeViewDto> getVehicleTypeById(@RequestHeader("Authorization") String bearerToken, @PathVariable Long id){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(reservationService.getVehicleTypeById(id), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @PostMapping("/create")
    public ResponseEntity<VehicleTypeViewDto> createVehicleModel(@RequestHeader("Authorization") String bearerToken, @RequestBody VehicleTypeDto vehicleTypeDto){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, false, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(reservationService.createVehicleType(vehicleTypeDto), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<VehicleTypeViewDto> updateVehicleModel(@RequestHeader("Authorization") String bearerToken, @PathVariable Long id, @RequestBody VehicleTypeDto vehicleTypeDto){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, false, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(reservationService.updateVehicleType(id, vehicleTypeDto), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteVehicleModel(@RequestHeader("Authorization") String bearerToken, @PathVariable Long id){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, false, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            reservationService.deleteVehicleType(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
