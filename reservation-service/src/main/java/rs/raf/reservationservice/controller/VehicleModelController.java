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
import rs.raf.core.dto.reservationservice.base.VehicleModelDto;
import rs.raf.core.dto.reservationservice.view.VehicleModelViewDto;
import rs.raf.core.util.DefinedRoleListFactory;
import rs.raf.reservationservice.domain.VehicleModel;
import rs.raf.reservationservice.security.service.TokenService;
import rs.raf.reservationservice.service.ReservationService;

import java.util.List;
@RestController
@RequestMapping("/vehicle_model")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleModelController {
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private TokenService tokenService;

    @GetMapping("/getAll")
    public ResponseEntity<List<VehicleModelViewDto>> getAllVehicleModels(@RequestHeader("Authorization") String bearerToken){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(reservationService.getAllVehicleModels(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<VehicleModelViewDto> getVehicleModelById(@RequestHeader("Authorization") String bearerToken, @PathVariable Long id){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(reservationService.getVehicleModelById(id), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @PostMapping("/create")
    public ResponseEntity<VehicleModelViewDto> createVehicleModel(@RequestHeader("Authorization") String bearerToken, @RequestBody VehicleModelDto vehicleModelDto){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, false, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(reservationService.createVehicleModel(vehicleModelDto), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<VehicleModelViewDto> updateVehicleModel(@RequestHeader("Authorization") String bearerToken, @PathVariable Long id, @RequestBody VehicleModelDto vehicleModelDto){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, false, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(reservationService.updateVehicleModel(id, vehicleModelDto), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteVehicleModel(@RequestHeader("Authorization") String bearerToken, @PathVariable Long id){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, false, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            reservationService.deleteVehicleModel(id);
            return new ResponseEntity<>(HttpStatus.OK);

        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
