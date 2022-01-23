package com.home.expiry.data.query;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

@Component
public class UserQuery {

    public static final String USER_NAME = "userName";

    public Query getByUserName(String userName){
        Query query = new Query();
        query.addCriteria(Criteria.where(USER_NAME).is(userName));
        return query;
    }
}
