package rs.raf.reservationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rs.raf.core.dto.reservationservice.base.FirmDto;
import rs.raf.core.dto.reservationservice.base.ReviewDto;
import rs.raf.core.dto.reservationservice.base.VehicleDto;
import rs.raf.core.dto.reservationservice.view.FirmViewDto;
import rs.raf.core.dto.reservationservice.view.ReviewViewDto;
import rs.raf.core.util.DefinedRoleListFactory;
import rs.raf.reservationservice.security.service.TokenService;
import rs.raf.reservationservice.service.ReservationService;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private TokenService tokenService;

    @GetMapping("/getAll")
    public ResponseEntity<List<ReviewViewDto>> getAllReviews(@RequestHeader("Authorization") String bearerToken){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(reservationService.getAllReviews(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @GetMapping("/getAllByClientUserId/{id}")
    public ResponseEntity<List<ReviewViewDto>> getAllReviewsByClientUserId(@RequestHeader("Authorization") String bearerToken, @PathVariable Long id){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, id)){
            return new ResponseEntity<>(reservationService.getAllReviewsByClientUserId(id), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @GetMapping("/getAllByFirmId/{id}")
    public ResponseEntity<List<ReviewViewDto>> getAllReviewsByFirmId(@RequestHeader("Authorization") String bearerToken, @PathVariable Long id){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(reservationService.getAllReviewsByFirmId(id), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<ReviewViewDto> getReviewById(@RequestHeader("Authorization") String bearerToken, @PathVariable Long id){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(reservationService.getReviewById(id), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @GetMapping("/getByClientUserIdAndFirmId/{clientUserId}/{firmId}")
    public ResponseEntity<ReviewViewDto> getReviewByClientUserIdAndFirmId(@RequestHeader("Authorization") String bearerToken, @PathVariable Long clientUserId, @PathVariable Long firmId){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, clientUserId)){
            return new ResponseEntity<>(reservationService.getReviewByClientUserIdAndFirmId(clientUserId, firmId), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @PostMapping("/create")
    public ResponseEntity<ReviewViewDto> createReview(@RequestHeader("Authorization") String bearerToken, @RequestBody ReviewDto reviewDto){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(reservationService.createReview(reviewDto), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ReviewViewDto> updateReview(@RequestHeader("Authorization") String bearerToken, @PathVariable Long id, ReviewDto reviewDto){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            return new ResponseEntity<>(reservationService.updateReview(id, reviewDto), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @PutMapping("/updateByClientUserIdAndFirmId/{clientUserId}/{firmId}")
    public ResponseEntity<ReviewViewDto> updateReviewByClientUserIdAndFirmId(@RequestHeader("Authorization") String bearerToken, @PathVariable Long clientUserId, @PathVariable Long firmId, ReviewDto reviewDto){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, clientUserId)){
            return new ResponseEntity<>(reservationService.updateReviewByClientUserIdAndFirmId(clientUserId, firmId, reviewDto), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteReview(@RequestHeader("Authorization") String bearerToken, @PathVariable Long id){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, null)){
            reservationService.deleteReview(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @DeleteMapping("/deleteByClientUserIdAndFirmId/{clientUserId}/{firmId}")
    public ResponseEntity<?> deleteReviewByClientUserIdAndFirmId(@RequestHeader("Authorization") String bearerToken, @PathVariable Long clientUserId, @PathVariable Long firmId){
        List<String> definedRoles = DefinedRoleListFactory.generateDefinedRoles(true, true, true);
        if(tokenService.checkSecurity(bearerToken, definedRoles, clientUserId)){
            reservationService.deleteReviewByClientUserIdAndFirmId(clientUserId, firmId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
