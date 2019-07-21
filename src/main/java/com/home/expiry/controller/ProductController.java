package com.home.expiry.controller;


import com.home.expiry.service.ProductService;
import com.home.expiry.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping()
    public void insert(@RequestBody Product product){
        productService.insert(product);
    }

    @GetMapping()
    public List<Product> all(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable String id){
        return productService.getById(id);
    }

    @DeleteMapping("/reset")
    public void deleteAll(){
        productService.deleteAll();
    }

}
