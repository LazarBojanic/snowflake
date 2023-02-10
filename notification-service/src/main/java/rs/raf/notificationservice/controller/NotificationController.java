package rs.raf.notificationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.raf.core.dto.notificationservice.base.NotificationDto;
import rs.raf.notificationservice.service.EmailService;

@RestController
@RequestMapping("/notification/")
public class NotificationController {
    @Autowired
    private EmailService emailService;


    @PostMapping("/hello")
    public ResponseEntity<NotificationDto> sendHelloNotification(@RequestBody NotificationDto notificationDto){
        emailService.sendSimpleMessage(notificationDto);
        return new ResponseEntity<>(notificationDto, HttpStatus.OK);
    }
}
