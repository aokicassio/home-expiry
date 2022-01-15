package com.home.expiry.data.query;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ProductQuery {

    public static final String EXPIRY_DATE = "expiryDate";

    public Query getAllExpiredQuery(){
        Query query = new Query();
        query.addCriteria(Criteria.where(EXPIRY_DATE).lt(today()));
        return query;
    }

    public Query getAllDueQuery(){
        Query query = new Query();
        query.addCriteria(Criteria.where(EXPIRY_DATE).is(today()));
        return query;
    }

    private LocalDate today(){
        return LocalDate.now();
    }
}
