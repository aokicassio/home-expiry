package com.home.expiry.service;

import com.home.expiry.model.Product;

import java.util.List;

public interface ExpirationService {

    List<Product> retrieveAllExpired();

    List<Product> retrieveAllDue();
}
