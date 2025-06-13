package com.felipesantos.projetosecurity.service;

import com.felipesantos.projetosecurity.dto.AccountCredentialsDTO;
import com.felipesantos.projetosecurity.dto.TokenDTO;
import com.felipesantos.projetosecurity.model.User;
import com.felipesantos.projetosecurity.repository.UserRepository;
import com.felipesantos.projetosecurity.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider tokenProvider;
    @Autowired
    private UserRepository userRepository;

    public TokenDTO login(AccountCredentialsDTO dto){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getUsername(),
                        dto.getPassword()
                )
        );

        User user = userRepository.findByUsername(dto.getUsername());
        if (user == null) throw new UsernameNotFoundException("Username " + dto.getUsername() + " not found");
        return tokenProvider.createAccessToken(user.getUsername(),user.getPassword());
    }
}
