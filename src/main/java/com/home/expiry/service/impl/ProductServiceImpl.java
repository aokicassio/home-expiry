package com.home.expiry.service.impl;

import com.home.expiry.data.repository.ProductRepository;
import com.home.expiry.model.Product;
import com.home.expiry.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void insert(Product product) {
        productRepository.insert(product);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll(Sort.by(Sort.Direction.ASC, "expiryDate"));
    }

    @Override
    public Product getById(String id) {
        Optional<Product> optional = productRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    public void deleteById(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public void deleteAll(){
        productRepository.deleteAll();
    }
}
