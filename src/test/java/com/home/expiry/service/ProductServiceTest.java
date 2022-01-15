package com.home.expiry.service;

import com.home.expiry.data.repository.ProductRepository;
import com.home.expiry.model.Product;
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
public class ProductServiceTest {

    private ProductServiceImpl productService;

    @Mock
    private ProductRepository repository;

    private static final String ID = "00000000";

    @Before
    public void init(){
        productService = new ProductServiceImpl(repository);
    }

    @Test
    public void testInsert(){
        Product product = generateProduct();
        when(repository.insert((Product) any())).thenReturn(product);

        productService.insert(product);
    }

    @Test
    public void testGetAll(){
        List<Product> productList = new ArrayList<>();
        productList.add(generateProduct());

        when(repository.findAll()).thenReturn(productList);

        List<Product> response = productService.getAll();

        Assert.assertNotNull(response);
        Assert.assertFalse(response.isEmpty());
    }

    @Test
    public void testGetById(){
        when(repository.findById(anyString())).thenReturn(Optional.of(generateProduct()));

        Product response = productService.getById(ID);

        Assert.assertNotNull(response);
    }

    @Test
    public void testDeleteById(){
        doNothing().when(repository).deleteById(anyString());

        productService.deleteById(ID);
    }

    @Test
    public void testDeleteAll(){
        doNothing().when(repository).deleteAll();
        productService.deleteAll();
    }

    private Product generateProduct(){
        return new Product("Test", LocalDate.now());
    }

}
