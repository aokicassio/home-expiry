package com.home.expiry.service;

import com.home.expiry.data.query.ProductQuery;
import com.home.expiry.model.Product;
import com.home.expiry.service.impl.ExpirationServiceImpl;
import com.home.expiry.test.utils.ProductTestUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ExpirationServiceTest {

    private ExpirationServiceImpl expirationService;

    @Mock
    private MongoTemplate mongoTemplate;

    @Mock
    private ProductQuery productQuery;

    @Before
    public void init(){
        expirationService = new ExpirationServiceImpl(mongoTemplate, productQuery);
    }

    @Test
    public void testRetrieveAllExpired(){
        Query query = new Query();
        query.addCriteria(Criteria.where("expiryDate").lte(LocalDate.now()));

        when(productQuery.getAllExpiredQuery()).thenReturn(query);
        when(mongoTemplate.find(query, Product.class)).thenReturn(ProductTestUtils.generateExpiredList());

        List<Product> response = expirationService.retrieveAllExpired();

        Assert.assertNotNull(response);
        Assert.assertFalse(response.isEmpty());
        Assert.assertTrue(response.get(0).getExpiryDate().isBefore(LocalDate.now()));
    }

    @Test
    public void retrieveAllDue(){
        Query query = new Query();
        query.addCriteria(Criteria.where("expiryDate").gte(LocalDate.now()));

        when(productQuery.getAllDueQuery()).thenReturn(query);
        when(mongoTemplate.find(query, Product.class)).thenReturn(ProductTestUtils.generateDueList());

        List<Product> response = expirationService.retrieveAllDue();

        Assert.assertNotNull(response);
        Assert.assertFalse(response.isEmpty());
        Assert.assertTrue(response.get(0).getExpiryDate().isAfter(LocalDate.now()));
    }

}
