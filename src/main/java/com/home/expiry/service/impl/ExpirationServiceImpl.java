package com.home.expiry.service.impl;

import com.home.expiry.data.query.ProductQuery;
import com.home.expiry.service.ExpirationService;
import com.home.expiry.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpirationServiceImpl implements ExpirationService {

    @Autowired
    private ProductQuery productQuery;

    @Override
    public List<Product> retrieveAllExpired() {
        return productQuery.queryAllExpired();
    }

    @Override
    public List<Product> retrieveAllDue() {
        return productQuery.queryAllDue();
    }
}
