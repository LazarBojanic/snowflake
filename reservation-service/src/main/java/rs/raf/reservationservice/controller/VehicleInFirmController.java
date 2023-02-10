package rs.raf.reservationservice.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.raf.core.dto.reservationservice.base.VehicleInFirmDto;
import rs.raf.core.dto.reservationservice.view.VehicleInFirmViewDto;
import rs.raf.core.util.DefinedRoleListFactory;
import rs.raf.reservationservice.security.service.TokenService;
import rs.raf.reservationservice.service.ReservationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/vehicle_in_firm")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleInFirmController {
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private TokenService tokenService;

    @GetMapping("/getAll/{firmId}")
    public ResponseEntity<List<VehicleInFirmViewDto>> getAllVehiclesInFirmWithFirmId(@RequestHeader("Authorization") String bearerToken, @PathVariable Long firmId){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(reservationService.getAllVehiclesInFirmWithFirmId(firmId), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @GetMapping("/get/{firmId}/{vehicleInFirmId}")
    public ResponseEntity<VehicleInFirmViewDto> getVehicleInFirmByIdWithFirmId(@RequestHeader("Authorization") String bearerToken, @PathVariable Long firmId, @PathVariable Long vehicleInFirmId){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(reservationService.getVehicleInFirmByIdWithFirmId(firmId, vehicleInFirmId), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @PostMapping("/create/{firmId}")
    public ResponseEntity<VehicleInFirmViewDto> createVehicleInFirmWithFirmId(@RequestHeader("Authorization") String bearerToken, @PathVariable Long firmId, @RequestBody VehicleInFirmDto vehicleInFirmDto){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, false, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(reservationService.createVehicleInFirmWithFirmId(firmId, vehicleInFirmDto), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @PutMapping("/update/{firmId}/{vehicleInFirmId}")
    public ResponseEntity<VehicleInFirmViewDto> updateVehicleInFirmWithFirmId(@RequestHeader("Authorization") String bearerToken, @PathVariable Long firmId, @PathVariable Long vehicleInFirmId, @RequestBody VehicleInFirmDto vehicleInFirmDto){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, false, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(reservationService.updateVehicleInFirmWithFirmId(firmId, vehicleInFirmId, vehicleInFirmDto), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @DeleteMapping("/delete/{firmId}/{vehicleInFirmId}")
    public ResponseEntity<?> deleteVehicleInFirmWithFirmId(@RequestHeader("Authorization") String bearerToken, @PathVariable Long firmId, @PathVariable Long vehicleInFirmId){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, false, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            reservationService.deleteVehicleInFirmWithFirmId(firmId, vehicleInFirmId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
