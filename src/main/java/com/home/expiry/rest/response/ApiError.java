package com.home.expiry.rest.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiError {

    private String type;
    private String title;
    private int status;
    private String detail;
    private String instance;

}
