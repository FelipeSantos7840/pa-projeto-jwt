package com.felipesantos.projetosecurity.controller;

import com.felipesantos.projetosecurity.dto.AccountCredentialsDTO;
import com.felipesantos.projetosecurity.dto.TokenDTO;
import com.felipesantos.projetosecurity.service.AuthService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AccountCredentialsDTO dto){
        if (dto == null || StringUtils.isBlank(dto.getPassword()) || StringUtils.isBlank(dto.getUsername())){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid Client Request");
        }

        TokenDTO token = authService.login(dto);

        if(token == null) ResponseEntity.status(HttpStatus.FORBIDDEN).body("Inavlid Client Request");

        return ResponseEntity.ok(token);
    }
}
