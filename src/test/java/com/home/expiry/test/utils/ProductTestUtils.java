package com.home.expiry.test.utils;

import com.home.expiry.model.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductTestUtils {

    public static List<Product> generateExpiredList(){
        List<Product> products = new ArrayList<>();
        products.add(generateExpiredProduct());

        return products;
    }

    public static Product generateExpiredProduct(){
        return new Product("productName", LocalDate.parse("2019-01-01"));
    }

    public static List<Product> generateDueList(){
        List<Product> products = new ArrayList<>();
        products.add(generateDueProduct());

        return products;
    }

    public static Product generateDueProduct(){
        return new Product("productName", LocalDate.now().plusMonths(1));
    }

}
