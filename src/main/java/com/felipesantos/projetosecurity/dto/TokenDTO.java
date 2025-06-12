package com.felipesantos.projetosecurity.dto;

import java.io.Serializable;
import java.util.Date;

public class TokenDTO implements Serializable {
    private static final  long serialVersionUID = 1l;

    private String username;
    private Boolean authenticated;
    private Date created;
    private Date expiration;
    private String accessToken;

    public TokenDTO() {
    }

    public TokenDTO(String username, Boolean authenticated, Date created, Date expiration, String accessToken) {
        this.username = username;
        this.authenticated = authenticated;
        this.created = created;
        this.expiration = expiration;
        this.accessToken = accessToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(Boolean authenticated) {
        this.authenticated = authenticated;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
