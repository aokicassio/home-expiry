package com.home.expiry.service.impl;

import com.home.expiry.data.query.ProductQuery;
import com.home.expiry.model.Product;
import com.home.expiry.service.ExpirationService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpirationServiceImpl implements ExpirationService {

    private MongoTemplate mongoTemplate;

    private ProductQuery productQuery;

    public ExpirationServiceImpl(MongoTemplate mongoTemplate, ProductQuery productQuery) {
        this.mongoTemplate = mongoTemplate;
        this.productQuery = productQuery;
    }

    @Override
    public List<Product> retrieveAllExpired() {
        return mongoTemplate.find(productQuery.getAllExpiredQuery(), Product.class);
    }

    @Override
    public List<Product> retrieveAllDue() {
        return mongoTemplate.find(productQuery.getAllDueQuery(), Product.class);
    }
}
