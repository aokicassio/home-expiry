package com.home.expiry.rest.controller;

import com.home.expiry.model.Product;
import com.home.expiry.service.ExpirationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/expiration")
public class ExpirationController {

    @Autowired
    private ExpirationService expireService;

    @RequestMapping(value = "/expired", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> allExpired(){
        return new ResponseEntity(expireService.retriveAllExpired(), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping(value = "/due", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> allDue(){
        return new ResponseEntity<>(expireService.retriveAllDue(), HttpStatus.OK);
    }

}
