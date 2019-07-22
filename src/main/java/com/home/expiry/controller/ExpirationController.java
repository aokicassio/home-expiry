package com.home.expiry.controller;

import com.home.expiry.model.Product;
import com.home.expiry.service.ExpirationService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Product> allExpired(){
        return expireService.retriveAllExpired();
    }

    @GetMapping
    @RequestMapping(value = "/due", method = RequestMethod.GET)
    public List<Product> allDue(){
        return expireService.retriveAllDue();
    }

}
