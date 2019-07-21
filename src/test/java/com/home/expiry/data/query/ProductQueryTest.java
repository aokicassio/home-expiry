package com.home.expiry.data.query;

import com.home.expiry.model.Product;
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
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ProductQueryTest {

    private ProductQuery productQuery;

    @Mock
    private MongoTemplate mongoTemplate;

    @Before
    public void init(){
        productQuery = new ProductQuery();
        ReflectionTestUtils.setField(productQuery, "mongoTemplate", mongoTemplate);
    }

    @Test
    public void testQueryAllExpired(){
        Query query = new Query();
        query.addCriteria(Criteria.where("expiryDate").lte(LocalDate.now()));

        when(mongoTemplate.find(query, Product.class)).thenReturn(ProductTestUtils.generateExpiredList());

        List<Product> response = productQuery.queryAllExpired();

        Assert.assertNotNull(response);
        Assert.assertFalse(response.isEmpty());

        Assert.assertTrue(response.get(0).getExpiryDate().isBefore(LocalDate.now()));
    }

    @Test
    public void testQueryAllDue(){
        Query query = new Query();
        query.addCriteria(Criteria.where("expiryDate").gte(LocalDate.now()));

        when(mongoTemplate.find(query, Product.class)).thenReturn(ProductTestUtils.generateDueList());

        List<Product> response = productQuery.queryAllDue();

        Assert.assertNotNull(response);
        Assert.assertFalse(response.isEmpty());
        Assert.assertTrue(response.get(0).getExpiryDate().isAfter(LocalDate.now()));
    }
}
