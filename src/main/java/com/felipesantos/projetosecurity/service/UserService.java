package com.felipesantos.projetosecurity.service;

import com.felipesantos.projetosecurity.dto.UserDTO;
import com.felipesantos.projetosecurity.model.User;
import com.felipesantos.projetosecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user != null) return user;
        else throw new UsernameNotFoundException("Username "+username+" not found!");
    }

    public List<UserDTO> findAll(){
        return List.of();
    }

    public UserDTO create(UserDTO dto){
        User user = new User();
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setUsername(dto.getUsername());
        user.setRole(dto.getRole());

        userRepository.save(user);
        return dto;
    }
}
