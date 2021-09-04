package com.home.expiry.rest.controller;

import com.home.expiry.model.Product;
import com.home.expiry.service.ExpirationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/expiration")
public class ExpirationController {

    @Autowired
    private ExpirationService expireService;

    @GetMapping(value = "/expired")
    public ResponseEntity<List<Product>> allExpired(){
        return new ResponseEntity<>(expireService.retrieveAllExpired(), HttpStatus.OK);
    }

    @GetMapping(value = "/due")
    public ResponseEntity<List<Product>> allDue(){
        return new ResponseEntity<>(expireService.retrieveAllDue(), HttpStatus.OK);
    }

}
