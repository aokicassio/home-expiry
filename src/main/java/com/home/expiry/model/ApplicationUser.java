package com.home.expiry.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class ApplicationUser {

    @Id
    private long id;

    private String userName;

    private String password;
}
