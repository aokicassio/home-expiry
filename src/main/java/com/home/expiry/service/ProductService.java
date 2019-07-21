package com.home.expiry.service;

import com.home.expiry.model.Product;

import java.util.List;

public interface ProductService {

    void insert(Product product);

    List<Product> getAll();

    Product getById(String id);

    void delete(Product product);

    void deleteById(String id);

    void deleteAll();
}
