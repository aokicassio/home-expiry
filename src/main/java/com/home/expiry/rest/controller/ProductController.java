package com.home.expiry.rest.controller;


import com.home.expiry.service.ProductService;
import com.home.expiry.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping()
    public ResponseEntity insert(@RequestBody Product product){
        productService.insert(product);

        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity<List<Product>> all(){
        return new ResponseEntity<List<Product>>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable String id){
        Optional<Product> optional = Optional.of(productService.getById(id));

        return optional.isPresent() ? ResponseEntity.ok(optional.get())
                                    : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/reset")
    public ResponseEntity deleteAll(){
        productService.deleteAll();

        return ResponseEntity.ok().build();
    }

}