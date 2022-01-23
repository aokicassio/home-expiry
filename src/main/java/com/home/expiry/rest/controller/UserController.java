package com.home.expiry.rest.controller;

import com.home.expiry.model.ApplicationUser;
import com.home.expiry.service.ApplicationUserRegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private ApplicationUserRegistrationService applicationUserRegistrationService;

    public UserController(ApplicationUserRegistrationService userRegistrationService) {
        this.applicationUserRegistrationService = userRegistrationService;
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody ApplicationUser user){
        applicationUserRegistrationService.register(user);

        return ResponseEntity.ok().build();
    }
}
