package com.home.expiry.controller;

import com.home.expiry.service.ExpirationService;
import com.home.expiry.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/expiration")
public class ExpirationController {

    @Autowired
    private ExpirationService expireService;

    @GetMapping
    @RequestMapping("/expired")
    public List<Product> allExpired(){
        return expireService.retriveAllExpired();
    }

    @GetMapping
    @RequestMapping("/due")
    public List<Product> allDue(){
        return expireService.retriveAllDue();
    }
}
