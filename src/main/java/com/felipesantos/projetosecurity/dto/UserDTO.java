package com.felipesantos.projetosecurity.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.felipesantos.projetosecurity.model.Role;

import java.io.Serializable;

public class UserDTO implements Serializable {
    private static final  long serialVersionUID = 1l;

    private Long id;
    private String name;
    private String username;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String password;
    private Role role;

    public UserDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
