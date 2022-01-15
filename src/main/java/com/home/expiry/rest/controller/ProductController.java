package com.home.expiry.rest.controller;


import com.home.expiry.rest.error.exception.NotFoundException;
import com.home.expiry.rest.error.message.ErrorMessage;
import com.home.expiry.service.ProductService;
import com.home.expiry.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    public ResponseEntity insert(@RequestBody Product product){

        //TODO validation of input
        productService.insert(product);

        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity<List<Product>> all(){
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable String id){
        Optional<Product> optional = Optional.ofNullable(productService.getById(id));

        if(!optional.isPresent()){
            NotFoundException notFoundException = new NotFoundException(ErrorMessage.PRODUCT_NOT_FOUND.getTitle());
            notFoundException.setErrorMessage(ErrorMessage.PRODUCT_NOT_FOUND);
            throw notFoundException;
        }

        return ResponseEntity.ok(optional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id){
        productService.deleteById(id);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/reset")
    public ResponseEntity deleteAll(){
        productService.deleteAll();

        return ResponseEntity.ok().build();
    }

}
