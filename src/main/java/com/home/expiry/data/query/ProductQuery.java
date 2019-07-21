package com.home.expiry.data.query;

import com.home.expiry.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ProductQuery {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Product> queryAllExpired(){
        Query query = new Query();
        query.addCriteria(Criteria.where("expiryDate").lte(LocalDate.now()));
        List<Product> products = mongoTemplate.find(query, Product.class);

        return products;
    }

    public List<Product> queryAllDue(){
        Query query = new Query();
        query.addCriteria(Criteria.where("expiryDate").gte(LocalDate.now()));
        List<Product> products = mongoTemplate.find(query, Product.class);

        return products;
    }
}
