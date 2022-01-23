package com.home.expiry.config.security.user;

import com.home.expiry.data.query.UserQuery;
import com.home.expiry.model.ApplicationUser;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private MongoTemplate mongoTemplate;

    private UserQuery userQuery;

    public JwtUserDetailsService(MongoTemplate mongoTemplate, UserQuery userQuery) {
        this.mongoTemplate = mongoTemplate;
        this.userQuery = userQuery;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        ApplicationUser applicationUser = mongoTemplate.findOne(userQuery.getByUserName(username), ApplicationUser.class);

        if (applicationUser == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return new org.springframework.security.core.userdetails.User(applicationUser.getUserName(), applicationUser.getPassword(),
                new ArrayList<>());
    }


}
