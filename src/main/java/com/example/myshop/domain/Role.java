package com.example.myshop.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, ADMIN, MANAGER;

    @Override
    public String getAuthority() {

        return name();
    }
}
