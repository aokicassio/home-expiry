package com.home.expiry.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
public class Product {

    @Id
    public String id;

    private String name;

    private Brand brand;

    private LocalDate expiryDate;

    public Product(String name, LocalDate expiryDate){
        this.name = name;
        this.expiryDate = expiryDate;
    }

}
