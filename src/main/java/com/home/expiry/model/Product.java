package com.home.expiry.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
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
