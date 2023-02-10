package rs.raf.reservationservice.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.raf.core.dto.reservationservice.base.VehicleDto;
import rs.raf.core.dto.reservationservice.view.VehicleViewDto;
import rs.raf.core.util.DefinedRoleListFactory;
import rs.raf.reservationservice.security.service.TokenService;
import rs.raf.reservationservice.service.ReservationService;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/vehicle")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleController {
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private TokenService tokenService;
    @GetMapping("/getAll")
    public ResponseEntity<List<VehicleViewDto>> getAllVehicles(@RequestHeader("Authorization") String bearerToken){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(reservationService.getAllVehicles(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<VehicleViewDto> getVehicleById(@RequestHeader("Authorization") String bearerToken, @PathVariable Long id){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(reservationService.getVehicleById(id), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @PostMapping("/create")
    public ResponseEntity<VehicleViewDto> createVehicle(@RequestHeader("Authorization") String bearerToken, @RequestBody VehicleDto vehicleDto){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(reservationService.createVehicle(vehicleDto), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<VehicleViewDto> updateVehicle(@RequestHeader("Authorization") String bearerToken, @PathVariable Long id, @RequestBody VehicleDto vehicleDto){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(reservationService.updateVehicle(id, vehicleDto), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteVehicle(@RequestHeader("Authorization") String bearerToken, @PathVariable Long id){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            reservationService.deleteVehicle(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
