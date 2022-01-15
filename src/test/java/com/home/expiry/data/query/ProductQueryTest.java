package com.home.expiry.data.query;

import org.bson.Document;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.Query;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ProductQueryTest {

    private ProductQuery productQuery;

    private String currentDate;

    @Before
    public void init(){
        productQuery = new ProductQuery();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now();
        currentDate = dtf.format(localDate);
    }

    @Test
    public void getAllExpiredQuery(){
        Query query = productQuery.getAllExpiredQuery();

        assertNotNull(query);
        Document document = query.getQueryObject();
        document.get("expiryDate").toString();

        String criteria = String.valueOf(document.get("expiryDate"));
        String expected = String.format("$lt=%s", currentDate);

        assertTrue(criteria.contains(expected));
    }

    @Test
    public void testGetAllDueQuery(){
        Query query = productQuery.getAllDueQuery();
        assertNotNull(query);
        Document document = query.getQueryObject();
        document.get("expiryDate").toString();

        String criteria = String.valueOf(document.get("expiryDate"));
        String expected = currentDate;

        assertTrue(criteria.contains(expected));
    }
}
