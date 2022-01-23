package com.home.expiry.config.security.jwt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -3566948160369656763L;

    private final String jwttoken;

}
