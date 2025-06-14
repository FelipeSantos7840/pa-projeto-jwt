package com.felipesantos.projetosecurity.service;

import com.felipesantos.projetosecurity.dto.UserDTO;
import com.felipesantos.projetosecurity.model.User;
import com.felipesantos.projetosecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user != null) return user;
        else throw new UsernameNotFoundException("Username "+username+" not found!");
    }

    public List<UserDTO> findAll(){
        List<User> users = userRepository.findAll();

        List<UserDTO> userDTOs = users.stream().map(
                (entity) -> {
                    UserDTO dto = new UserDTO();
                    dto.setId(entity.getId());
                    dto.setName(entity.getName());
                    dto.setUsername(entity.getUsername());
                    dto.setPassword(entity.getPassword());
                    dto.setRole(entity.getRole());
                    return dto;
                }
        ).toList();


        return userDTOs;
    }
}
