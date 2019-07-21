package com.home.expiry.service;

import com.home.expiry.data.query.ProductQuery;
import com.home.expiry.data.repository.ProductRepository;
import com.home.expiry.model.Product;
import com.home.expiry.service.impl.ExpirationServiceImpl;
import com.home.expiry.service.impl.ProductServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ExpirationServiceTest {

    private ExpirationServiceImpl expirationService;

    @Mock
    private ProductQuery productQuery;

    @Before
    public void init(){
        expirationService = new ExpirationServiceImpl();
        ReflectionTestUtils.setField(expirationService, "productQuery", productQuery);
    }

    @Test
    public void testRetriveAllExpired(){
        when(productQuery.queryAllExpired()).thenReturn(generateExpiredList());

        List<Product> response = expirationService.retriveAllExpired();

        Assert.assertNotNull(response);
        Assert.assertFalse(response.isEmpty());
    }

    @Test
    public void retriveAllDue(){
        when(productQuery.queryAllDue()).thenReturn(generateDueList());

        List<Product> response = expirationService.retriveAllDue();

        Assert.assertNotNull(response);
        Assert.assertFalse(response.isEmpty());
    }

    private List<Product> generateExpiredList(){
        List<Product> products = new ArrayList<>();
        products.add(generateExpiredProduct());

        return products;
    }

    private Product generateExpiredProduct(){
        return new Product("productName", LocalDate.parse("2019-01-01"));
    }

    private List<Product> generateDueList(){
        List<Product> products = new ArrayList<>();
        products.add(generateDueProduct());

        return products;
    }

    private Product generateDueProduct(){
        return new Product("productName", LocalDate.now().plusMonths(1));
    }

}
