package com.home.expiry.service.impl;

import com.home.expiry.data.query.UserQuery;
import com.home.expiry.data.repository.ApplicationUserRepository;
import com.home.expiry.model.ApplicationUser;
import com.home.expiry.rest.error.exception.BadRequestException;
import com.home.expiry.rest.error.message.ErrorMessage;
import com.home.expiry.service.ApplicationUserRegistrationService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserRegistrationServiceImpl implements ApplicationUserRegistrationService {

    private ApplicationUserRepository applicationUserRepository;

    private MongoTemplate mongoTemplate;

    private UserQuery userQuery;

    private PasswordEncoder passwordEncoder;

    public ApplicationUserRegistrationServiceImpl(ApplicationUserRepository applicationUserRepository, MongoTemplate mongoTemplate, UserQuery userQuery, PasswordEncoder passwordEncoder) {
        this.applicationUserRepository = applicationUserRepository;
        this.mongoTemplate = mongoTemplate;
        this.userQuery = userQuery;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ApplicationUser register(ApplicationUser applicationUser) {
        ApplicationUser existingUser = mongoTemplate.findOne(userQuery.getByUserName(applicationUser.getUserName()), ApplicationUser.class);
        if(existingUser != null){
            BadRequestException notFoundException = new BadRequestException(ErrorMessage.USER_ALREADY_EXISTS);
            throw notFoundException;
        }
        applicationUser.setPassword(passwordEncoder.encode(applicationUser.getPassword()));
        return applicationUserRepository.insert(applicationUser);
    }
}
